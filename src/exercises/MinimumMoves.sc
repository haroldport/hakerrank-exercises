val a = Array(1234, 4321)
val m = Array(2345, 3214)

def movesToMatchNumber(a: Int, b: Int): Int = {
  if(a < b) return b - a
  if(a > b) return a - b
  0
}

def minimumMoves(a: Array[Int], m: Array[Int]): Int = {
  (a, m).zipped.flatMap((x,y) => {
    val secondArr: Array[Int] = y.toString.map(_.asDigit).toArray
    x.toString.zipWithIndex.map{ case(d, i) =>
      movesToMatchNumber(d.asDigit, secondArr(i))
    }
  }).sum
}

minimumMoves(a, m)