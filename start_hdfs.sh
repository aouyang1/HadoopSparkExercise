#!/usr/bin/env bash

# only use for running hadoop locally

# reformats hdfs local namenode and datanodes
hdfs namenode -format
${HADOOP_HOME}/sbin/start-dfs.sh

# create main folders for hdfs and hive
hdfs dfs -mkdir /user
hdfs dfs -mkdir /tmp
hdfs dfs -mkdir /user/hive
hdfs dfs -mkdir /user/hive/warehouse
hdfs dfs -chmod g+w /tmp
hdfs dfs -chmod g+w /user/hive/warehouse




