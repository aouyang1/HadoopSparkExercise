import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql._

object price_data {

  case class Tick(date_str: String, price: Double, volume: Int)

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("PriceDataExercise")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._ 

    val folder_name = "hdfs://localhost:9000/user/price_data_full"

    def convert_to_30min(timestamp: String): String = {
        val min30 = timestamp.slice(11,13).toInt/30*30
        timestamp.take(11) + f"${min30}%02d" + "00"
    }

    val rawTicksRDD = sc.textFile(folder_name)

    val num_partitions = rawTicksRDD.partitions.size

    val ticksDF = rawTicksRDD.map(tick => {
                                     val tokens = tick.split(";")
                                     Tick(convert_to_30min(tokens(0)), 
                                          tokens(1).toDouble, 
                                          tokens(2).toInt)
                                  }).toDF()

    val ticks_min30_DF = ticksDF.groupBy("date_str")
                                .agg("price" -> "avg", "volume" -> "sum")
                                .orderBy("date_str")

    ticks_min30_DF.rdd
                  .repartition(num_partitions)
                  .saveAsTextFile(folder_name + "_spark-df")

  }
}
