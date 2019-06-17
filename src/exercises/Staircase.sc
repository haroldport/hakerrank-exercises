def staircase(n: Int) {
  for(i <- 1 to n) println(s"${' '.toString * (n-i)}${"#" * i}")
}

staircase(4)
