import Window.Frame

import java.awt.Color

object Main {
  def main(args: Array[String]): Unit = {
    val frame = Frame()
    Thread.sleep(1000)
    println(s"frame = ${frame}")
  }
}
