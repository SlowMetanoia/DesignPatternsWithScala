package Shapes

import java.awt
import scala.math.{ceil, log}
import scala.util.Random

case class Color(red: Double, green: Double, blue: Double) {
  def awtColor: awt.Color = {
    new java.awt.Color(red.toFloat, green.toFloat, blue.toFloat)
  }
}
object Color{
  private def series[T](first:T)(next:T=>T):LazyList[T] = first#::series(next(first))(next)
  def defaultColorSet(n:Int):Seq[Color] = {
    val eachColorVariants = ceil(log(n.toDouble)/log(3.0))
    val dx = 1.0/eachColorVariants
    def colorVariants(dx:Double):LazyList[Double] = series(0.0)(_+dx).takeWhile(_<1)
    
  }
  def randomColorSet(n:Int, seed:Option[Long] = None) = {
    seed.foreach(Random.setSeed)
  }
}