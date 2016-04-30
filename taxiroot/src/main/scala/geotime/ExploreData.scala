package geotime

import java.text.SimpleDateFormat

import com.github.nscala_time.time.Imports._

object ExploreData {
  def main(args: Array[String]) {
//    val sparkConf = new SparkConf()
//      .setAppName("ExploreData")
//      .setMaster("local[4]")
//      .set("spark.executor.memory", "2g")
//      .set("spark.rdd.compress", "true")
//    val sc = new SparkContext(sparkConf)

    val dt1 = new DateTime(2014, 9, 4, 9, 0)
    val dt2 = new DateTime(2014, 10, 31, 15, 0)
    val dt3 = dt1 + 60.days

    println(dt1.dayOfYear.get)
    println("dt1 < dt2: " + (dt1 < dt2))
    println("dt2 < dt3: " + (dt2 < dt3))

    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = format.parse("2014-10-12 10:30:44")
    val datetime = new DateTime(date)

    println("parsed DateTime object: " + datetime)

    val d = new Duration(dt1, dt2)

    println("duration: ")
    println(d.getMillis + " ms")
    println(d.getStandardHours + " h")
    println(d.getStandardDays + " days")
  }
}