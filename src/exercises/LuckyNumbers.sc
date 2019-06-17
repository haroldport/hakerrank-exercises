val cacheIsPrime = scala.collection.mutable.Map[Int, Boolean]()
val cacheSum = scala.collection.mutable.Map[Long, Int]()
val cacheSumSquare = scala.collection.mutable.Map[Long, Int]()
val cacheTuplesPrime = scala.collection.mutable.Map[(Int, Int), Boolean]()

def isPrime(a: Int): Boolean = {
  if(cacheIsPrime.exists(_._1 == a)) return cacheIsPrime(a)
  a match {
    case x if x <= 1 =>
      cacheIsPrime += (a -> false)
      false
    case x if x == 2 =>
      cacheIsPrime += (a -> true)
      true
    case x if x % 2 == 0 =>
      cacheIsPrime += (a -> false)
      false
    case x =>
      for(i <- 3 to x) {
        if (a % i == 0) {
          cacheIsPrime += (a -> false)
          return false
        }
        cacheIsPrime += (a -> true)
        true
      }
      val z = !(3 until x).exists(y => x % y == 0)
      cacheIsPrime += (a -> z)
      z
  }
}

def luckyNumbers(a: Long, b: Long): Long = {
  var count: BigInt = 0
  var it = a
  while(it <= b) {
    val sumNormal = if(cacheSum.exists(_._1 == it)) cacheSum(it) else {
      val x = it.toString.map(_.asDigit).sum
      cacheSum += (it -> x)
      x
    }
    val sumSquare = if(cacheSumSquare.exists(_._1 == it)) cacheSumSquare(it) else {
      val x = it.toString.map(x => x.asDigit * x.asDigit).sum
      cacheSumSquare += (it -> x)
      x
    }
    if(cacheTuplesPrime.exists(_._1 == (sumNormal, sumSquare))) {
      val isTuplePrime = cacheTuplesPrime((sumNormal, sumSquare))
      if(isTuplePrime) count += 1
    } else {
      val isTuplePrime = isPrime(sumNormal) && isPrime(sumSquare)
      if(isTuplePrime) count += 1
      cacheTuplesPrime += ((sumNormal, sumSquare) -> isTuplePrime)
    }
    it += 1
  }
  count.toLong
}

val a = 20L
val b = 20725L

luckyNumbers(a, b)

