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

# Hadoop installation
```
http://mirror.nexcess.net/apache/hadoop/common/stable/hadoop-2.6.0.tar.gz 
tar -zxvf hadoop-2.6.0.tar.gz -C /usr/local
```
# Pig installation
```
wget http://psg.mtu.edu/pub/apache/pig/pig-0.14.0/pig-0.14.0-src.tar.gz 
tar -zxvf pig-0.14.0-src.tar.gz -C /usr/local
```
# Hive installation
```
wget http://apache.mirrors.lucidnetworks.net/hive/stable/apache-hive-1.1.0-bin.tar.gz
tar -zxvf apache-hive-1.1.0-bin.tar.gz -C /usr/local
```
# Spark installation
```
wget http://www.apache.org/dyn/closer.cgi/spark/spark-1.3.0/spark-1.3.0-bin-hadoop2.4.tgz
tar -zxvf spark-1.3.0-bin-hadoop2.4.tgz -C /usr/local
```

```
~/.bashrc

export JAVA_HOME=/usr/bin/java
export PATH=$PATH:$JAVA_HOME

export HADOOP_HOME=/usr/local/hadoop
export PATH=$PATH:$HADOOP_HOME/bin

export SPARK_HOME=/usr/local/spark
export PATH=$PATH:$SPARK

export HIVE_HOME=/usr/local/hive
export PATH=$PATH:$HIVE_HOME/bin

export PIG_HOME=/usr/local/pig
export PATH=$PATH:$PIG_HOME/bin
```
