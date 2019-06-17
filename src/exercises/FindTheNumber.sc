val a = Array(1, 2, 3, 4, 5)
val k = 5

def findNumber(arr: Array[Int], k: Int): String = {
  val optionNumber = arr.find(_ == k)
  if(optionNumber.isDefined) "YES" else "NO"
}

findNumber(a, k)
