val l = 3
val r = 9

def oddNumbers(l: Int, r: Int): Array[Int] = {
  (l to r).filter(_ % 2 != 0).toArray
}

oddNumbers(3, 9)