def diagonalDifference(arr: Array[Array[Int]]): Int = {
  val result = new Array[Int](2)
  for {
    i <- arr.indices
    j <- arr.indices
  } {
    if(i == j) result(0) += arr(i)(j)
    if(i == (arr.length - j - 1)) result(1) += arr(i)(j)
  }
  (result(0) - result(1)).abs
}

val a = Array.ofDim[Int](3, 3)

a(0)(0) = 11
a(0)(1) = 2
a(0)(2) = 4
a(1)(0) = 4
a(1)(1) = 5
a(1)(2) = 6
a(2)(0) = 10
a(2)(1) = 8
a(2)(2) = -12

diagonalDifference(a)