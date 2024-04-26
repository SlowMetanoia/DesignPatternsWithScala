package Shapes

import java.awt.geom.Point2D
import scala.language.implicitConversions

case class Point(x: Double, y: Double){
  def point2D:Point2D = new Point2D.Double(x,y)
}

object Point{
  implicit def doubleTuple2Point(pair:(Double,Double)):Point = Point(pair._1, pair._2)
  implicit def intTuple2Point(pair:(Int,Int)):Point = Point(pair._1, pair._2)
  implicit def point2D2Point(point2D: Point2D):Point = Point(point2D.getX, point2D.getY)
}
