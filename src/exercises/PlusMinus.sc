def plusMinus(arr: Array[Int]) {
  val result = new Array[Double](3)
  arr.foreach {
    case x if x > 0 => result(0) += 1
    case x if x < 0 => result(1) += 1
    case _ => result(2) += 1
  }
  val positives: Double = result(0) / arr.length
  val negatives: Double = result(1) / arr.length
  val zeros: Double = result(2) / arr.length

  println("%.6f".format(positives))
  println("%.6f".format(negatives))
  println("%.6f".format(zeros))
}

val a = Array(-4, 3, -9, 0, 4, 1)

plusMinus(a)