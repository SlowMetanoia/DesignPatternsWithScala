package Shapes
import Shapes.ShapeOperations.scale

import java.awt.geom.AffineTransform

case class Rectangle(sizeX:Double, sizeY:Double) extends Shape {
  override def edgePoints: Seq[Point] = Seq(
    Point(0,0),
    Point(1,0),
    Point(1,1),
    Point(0,1)
  )

  override val affineTransform: AffineTransform = scale(sizeX,sizeY)
}
