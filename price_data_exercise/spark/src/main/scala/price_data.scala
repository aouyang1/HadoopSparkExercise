import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object price_data {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("PriceDataExercise")
    val sc = new SparkContext(conf)

    val file = sc.textFile("hdfs://localhost:9000/user/price_data_snippet")

    val prices = file.map(line => { val record = line.split(";")
				    (record(0), record(1).toDouble, record(2).toInt) 
				  })

    val prices30min = prices.map(record => ( { val ts = record._1 
					       val min30 = ts.slice(11,13).toInt/30*30
					       ts.take(11) + f"${min30}%02d" + "00" } , 
					     record._2, 
					     record._3) )

    val price_30min = prices30min.map(record => (record._1, (record._2, 1)) )
				 .reduceByKey( (x, y) => (x._1 + y._1, x._2 + y._2) )
				 .map(record => (record._1, record._2._1/record._2._2) )

    val vol_30min = prices30min.map(record => (record._1, record._3))
			       .reduceByKey(_+_)

    val price_vol_30min = price_30min.join(vol_30min)
				     .sortByKey()
				     .map(record => (record._1, record._2._1, record._2._2))

    price_vol_30min.saveAsTextFile("hdfs://localhost:9000/user/price_data_snippet_scala")
    
  }

}
