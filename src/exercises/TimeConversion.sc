import java.text.SimpleDateFormat

def timeConversion(s: String): String = {
  val inputTimeFormat = new SimpleDateFormat("hh:mm:ssa")
  val timeWithDateFormat = inputTimeFormat.parse(s)
  val outputTimeFormat = new SimpleDateFormat("HH:mm:ss")
  outputTimeFormat.format(timeWithDateFormat)
}

val inTime = "07:05:45PM"

timeConversion(inTime)