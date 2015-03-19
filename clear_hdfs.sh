#!/usr/bin/env bash

# removes all output files and folders from Spark and Pig examples

# remove spark outputs
hdfs dfs -rm /user/price_data_snippet_scala/*
hdfs dfs -rmdir /user/price_data_snippet_scala
hdfs dfs -rm /user/price_data_full_scala/*
hdfs dfs -rmdir /user/price_data_full_scala

# remove pig outputs
hdfs dfs -rm /user/aouyang1/price_data_snippet_pig/*
hdfs dfs -rmdir /user/aouyang1/price_data_snippet_pig
hdfs dfs -rm /user/aouyang1/price_data_full_pig/*
hdfs dfs -rmdir /user/aouyang1/price_data_full_pig
hdfs dfs -rmdir /user/aouyang1

