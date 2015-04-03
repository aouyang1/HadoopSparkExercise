import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object price_data {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("PriceDataExercise")
    val sc = new SparkContext(conf)

    val folder_name = "hdfs://localhost:9000/user/price_data_full"    

    def convert_to_30min(timestamp: String): String = {
        val min30 = timestamp.slice(11,13).toInt/30*30
        timestamp.take(11) + f"${min30}%02d" + "00"
    }

    val file = sc.textFile(folder_name)

    val ticks = file.map(line => { 
                            val record = line.split(";")
        				    (record(0), record(1).toDouble, record(2).toInt) 
				          })

    val ticks_min30 = ticks.map(record => (convert_to_30min(record._1), 
			       	                       record._2, 
                    				       record._3)).persist

    val price_min30 = ticks_min30.map(record => (record._1, (record._2, 1)))
                				 .reduceByKey( (x, y) => (x._1 + y._1, 
                                                          x._2 + y._2) )
                				 .map(record => (record._1, 
                                                 record._2._1/record._2._2) )

    val vol_min30 = ticks_min30.map(record => (record._1, record._3))
            			       .reduceByKey(_+_)

    val price_vol_min30 = price_min30.join(vol_min30)
				                     .sortByKey()
                				     .map(record => (record._1, 
                                                     record._2._1, 
                                                     record._2._2))

    price_vol_min30.saveAsTextFile(folder_name + "_spark")
    
  }

}
