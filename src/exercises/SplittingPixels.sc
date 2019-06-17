val rgbValues = Map(
  "Black" -> List(0, 0, 0),
  "White" -> List(255, 255, 255),
  "Red" -> List(255, 0, 0),
  "Green" -> List(0, 255, 0),
  "Blue" -> List(0, 0, 255)
)

def closestColor(pixels: Array[String]): Array[String] = {
  val default = "Ambiguous"
  pixels.map(x => {
    x.grouped(8).toList.map(Integer.parseInt(_, 2))
  }).map(sourceList => {
    val tuples = rgbValues.flatMap { case(key, value) =>
      Map(key ->
      scala.math.pow((sourceList, value).zipped.map((a, b) => {
        scala.math.pow(a - b, 2)
      }).sum, 0.5))
    }
    val minValue = tuples.minBy(_._2)
    val numberOfRepetitions = tuples.values.toList.count(_ == minValue._2)
    if(numberOfRepetitions > 1) default else minValue._1
  })
}

val arr = Array(
  "101111010110011011100100",
  "110000010101011111101111",
  "100110101100111111101101",
  "010111011010010110000011",
  "000000001111111111111111"
)

closestColor(arr)