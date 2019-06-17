import scala.collection.mutable.ListBuffer

def miniMaxSum(arr: Array[Int]) {
  val list = new ListBuffer[BigInt]()
  arr.indices foreach(x => {
    val newList = arr.toList.zipWithIndex.filter(_._2 != x).map(x => BigInt(x._1))
    list += newList.sum
  })
  println(s"${list.min} ${list.max}")
}

val a = Array(942381765, 627450398, 954173620, 583762094, 236817490)

miniMaxSum(a)