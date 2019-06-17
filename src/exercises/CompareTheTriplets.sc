def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
  val result = new Array[Int](2)
  (a, b).zipped.foreach((x,y) => {
    if(x > y) result(0) += 1
    if(x < y) result(1) += 1
  })
  result
}

val a = Array(7, 6, 75)
val b = Array(3, 9, 10)

compareTriplets(a, b)