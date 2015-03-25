# Hadoop and Spark Comparison

The purpose of this exercise is to implement a map reduce job across both a Hadoop and Spark framework. The data set is commodity 

Tasks:
1. [Install Hadoop 2.6](README.md#1-install-hadoop)
2. [Install Pig 0.14](README.md#2-install-pig)
3. [Install Hive 1.1.0](README.md#3-install-hive)
4. [Install Spark 1.3.0](README.md#3-install-spark)
5. [Copy price data to Hadoop Data File System (HDFS)]
6. [Write a Pig, Hive, and Spark job]
7. [Write results back into HDFS]
8. [Compare results and benchmark]

# 1. Install Hadoop 2.6
```
http://mirror.nexcess.net/apache/hadoop/common/stable/hadoop-2.6.0.tar.gz 
tar -zxvf hadoop-2.6.0.tar.gz -C /usr/local
```
change JAVA_HOME environment variable in /usr/local/hadoop-2.6.0/etc/hadoop/hadoop-env.sh
```
export JAVA_HOME=/usr
```
# 2. Install Pig 0.14
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

# Add to ~/.bashrc
```
export JAVA_HOME=/usr/bin/java
export PATH=$PATH:$JAVA_HOME

export HADOOP_HOME=/usr/local/hadoop-2.6.0
export PATH=$PATH:$HADOOP_HOME/bin

export PIG_HOME=/usr/local/pig-0.14.0
export PATH=$PATH:$PIG_HOME/bin

export HIVE_HOME=/usr/local/apache-hive-1.1.0-bin
export PATH=$PATH:$HIVE_HOME/bin

export SPARK_HOME=/usr/local/spark-1.3.0-bin-hadoop2.4
export PATH=$PATH:$SPARK
```
