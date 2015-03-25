# Hadoop and Spark Comparison

Tasks:

1. [Install Hadoop 2.6](README.md#1-install-hadoop-26)
2. [Install Pig 0.14](README.md#2-install-pig-014)
3. [Install Hive 1.1.0](README.md#3-install-hive-110)
4. [Install Spark 1.3.0](README.md#4-install-spark-130)
5. [Add environment variables](README.md#5-add-environment-variables)
6. [Setup HDFS](README.md#6-setup-hdfs)
7. [Write jobs](README.md#7-write-jobs)
8. [Compare results and benchmark](README.md#8-compare-results-and-benchmark)

The purpose of this exercise is to implement a map reduce job across both a Hadoop and Spark framework. The data set is commodity price data structured as so:

Column definition: Timestamp, Price, Volume

Timestamp string format: yyyymmdd HHMMSS

![price_data_snippet] (images/price_data_snippet.png)

The task is to implement in the various frameworks the average price and total volume for each 30 minute increment. Output should look like the following:

![min30_output] (images/min30_output.png)

## 1. Install Hadoop 2.6
    
    $ wget http://mirror.nexcess.net/apache/hadoop/common/stable/hadoop-2.6.0.tar.gz
    $ tar -zxvf hadoop-2.6.0.tar.gz -C /usr/local
    
After extraction, go to [Insight Hadoop dev](https://sites.google.com/a/insightdatascience.com/dataengineering/devsetups/hadoop) to setup Hadoop and HDFS

Since HDFS is shutdown each time on a local machine, the following bash scripts can be used to start HDFS, load and clear data in HDFS:

- start_hdfs.sh: starts HDFS (modify as needed)
- load_hdfs.sh: loads data into HDFS (modify as needed)
- clear_hdfs.sh: clears data from HDFS since overwriting will result in an error (modify as needed)

Be sure to set the scripts as executables

    $ sudo chmod +x start_hdfs.sh
    $ sudo chmod +x load_hdfs.sh
    $ sudo chmod +x clear_hdfs.sh

## 2. Install Pig 0.14

    $ wget http://psg.mtu.edu/pub/apache/pig/pig-0.14.0/pig-0.14.0-src.tar.gz 
    $ tar -zxvf pig-0.14.0-src.tar.gz -C /usr/local

## 3. Install Hive 1.1.0

    $ wget http://apache.mirrors.lucidnetworks.net/hive/stable/apache-hive-1.1.0-bin.tar.gz
    $ tar -zxvf apache-hive-1.1.0-bin.tar.gz -C /usr/local

## 4. Install Spark 1.3.0

    $ wget http://www.apache.org/dyn/closer.cgi/spark/spark-1.3.0/spark-1.3.0-bin-hadoop2.4.tgz
    $ tar -zxvf spark-1.3.0-bin-hadoop2.4.tgz -C /usr/local

Use the [Insight Spark dev](https://sites.google.com/a/insightdatascience.com/dataengineering/devsetups/spark-dev) to complete setup

## 5. Add environment variables
Add to ~/.bashrc

![bashrc](images/bashrc.png)

    $ source ~/.bashrc

## 6. Setup HDFS

On local machine start up, reformat HDFS

    $ ./start_hdfs.sh
    
Load data onto HDFS

    $ ./load_hdfs.sh
    
## 7. Write jobs
1. Convert timestamp to 30 minute intervals
2. Compute total volume for each time interval
3. Compute average price for each time interval
4. Write output to HDFS

Hadoop/Spark hints
- file hierarchy setup

```
project
     -> pig
         -> price_data.pig
         -> string_manip.py
     -> hive
         -> price_data.sql
     -> spark
           -> project.sbt
           -> src
               -> main
                    -> scala
                          -> price_data.scala
```

- Pig
  - Use UDFs for string manipulations
  - Run with the following command:
    
    ```
    $ pig -x mapreduce price_data.pig
    ```


- Hive
  - Create a table
  - Use concat, substr, if for string manipulations
  - Run with the following command:
    
    ```
    $ hive -f price_data.sql
    ```


- Spark
  - compile with sbt
    
    ```
    $ sbt package
    ```

  - jar file will reside in target/scala-2.10
  - Run with the following command:
    
    ```
    $ spark-submit --class "price_data" --master local[8] target/scala-2.10/price_data_2.10-1.0.jar
    ```


## 8. Compare results and benchmark

|File Size|Pig     |Hive    |Spark   |
|---------|--------|--------|--------|
|1.7MB    |0m10.46s|0m11.12s|0m05.60s|
|670MB    |3m15.53s|1m20.77s|0m39.73s|
