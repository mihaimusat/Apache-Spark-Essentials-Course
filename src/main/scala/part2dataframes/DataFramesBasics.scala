package part2dataframes

import org.apache.spark.sql.SparkSession

object DataFramesBasics extends App {

  // create a SparkSession
  val spark = SparkSession.builder()
    .appName("DataFrame Basics")
    .config("spark.master", "local")
    .getOrCreate()

  // read a Spark DataFrame
  val firstDF = spark.read
    .format("json")
    .option("inferSchema", "true")
    .load("src/main/resources/data/cars.json")

  // print the DataFrame
  firstDF.show()

  // print column types for a DataFrame
  firstDF.printSchema()

  firstDF.take(10).foreach(println)


}
