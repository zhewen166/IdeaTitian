package com.cn.agent

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

/**
 * Hello world!
 *
 */
object App3  {

  def main(args: Array[String]) {

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("word-count")
    val sc = new SparkContext(conf)

    //List("lib/spark-assembly_2.10-0.9.0-incubating-hadoop1.0.4.jar")
    val logFile = sc.textFile("/home/cz/spark/learning-spark-example/README.md") // Should be some file on your system

    val counts = logFile.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)
    println("finished-------")

  }
}
