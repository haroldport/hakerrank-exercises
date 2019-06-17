def birthdayCakeCandles(ar: Array[Int]): Int = {
  ar.groupBy(identity).map{ case (k,v) => (k, v.length) }.max._2
}

val a = Array(3, 2, 1, 3)

birthdayCakeCandles(a)