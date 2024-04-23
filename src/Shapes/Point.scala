package Shapes

import java.awt.geom.Point2D

case class Point(x: Double, y: Double){
  def point2D:Point2D = new Point2D.Double(x,y)
}
