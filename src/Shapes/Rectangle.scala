package Shapes
import Shapes.ShapeOperations.scale

import java.awt.geom.AffineTransform

case class Rectangle(sizeX:Double, sizeY:Double) extends Shape {
  override def edgePoints: Seq[Point] = Seq(
    Point(0,0),
    Point(sizeX,0),
    Point(sizeX,sizeY),
    Point(0,sizeY)
  )
}
