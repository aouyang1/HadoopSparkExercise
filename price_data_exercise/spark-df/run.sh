#!/usr/bin/env bash

${SPARK_HOME}/bin/spark-submit --class "price_data" --master local[8] target/scala-2.10/price_data_2.10-1.0.jar
