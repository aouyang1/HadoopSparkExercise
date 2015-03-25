#!/usr/bin/env bash

# copies local files to HDFS

hdfs dfs -copyFromLocal data/price_data/price_data_snippet /user
hdfs dfs -copyFromLocal data/price_data/price_data_full /user
