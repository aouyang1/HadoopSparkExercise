# InsightDataEngExamples

Implements an a Map Reduce job in Spark, Pig, and Hive

Tasks:

1. Install Hadoop 2.4+
2. Install Pig
3. Install Hive
4. Install Spark
5. Place price_data_snippet.txt onto HDFS
6. Write a Pig, Hive, and Spark job to compute the average price and total volume in 30 minute increments
7. Write results back into HDFS
8. Use hdfs dfs -cat to compare results

```
Pig installation
wget http://psg.mtu.edu/pub/apache/pig/pig-0.14.0/pig-0.14.0-src.tar.gz 
```

```
Hive installation
wget http://apache.mirrors.lucidnetworks.net/hive/stable/apache-hive-1.1.0-bin.tar.gz
```

```
Spark installation
wget http://www.apache.org/dyn/closer.cgi/spark/spark-1.3.0/spark-1.3.0-bin-hadoop2.4.tgz
```

