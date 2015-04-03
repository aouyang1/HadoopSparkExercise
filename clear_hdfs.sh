#!/usr/bin/env bash

# removes all output files and folders from Spark and Pig examples

# remove spark outputs
hdfs dfs -rm /user/price_data_snippet_spark/*
hdfs dfs -rmdir /user/price_data_snippet_spark
hdfs dfs -rm /user/price_data_full_spark/*
hdfs dfs -rmdir /user/price_data_full_spark

# remove spark-df outputs
hdfs dfs -rm /user/price_data_snippet_spark-df/*
hdfs dfs -rmdir /user/price_data_snippet_spark-df
hdfs dfs -rm /user/price_data_full_spark-df/*
hdfs dfs -rmdir /user/price_data_full_spark-df

# remove pig outputs
hdfs dfs -rm /user/aouyang1/price_data_snippet_pig/*
hdfs dfs -rmdir /user/aouyang1/price_data_snippet_pig
hdfs dfs -rm /user/aouyang1/price_data_full_pig/*
hdfs dfs -rmdir /user/aouyang1/price_data_full_pig
hdfs dfs -rmdir /user/aouyang1

# remove hive outputs
hdfs dfs -rm /user/price_data_snippet_hive/*
hdfs dfs -rmdir /user/price_data_snippet_hive
hdfs dfs -rm /user/price_data_full_hive/*
hdfs dfs -rmdir /user/price_data_full_hive
