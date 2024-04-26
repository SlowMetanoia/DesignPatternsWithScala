package Shapes

import Shapes.ShapeOperations.idleTransform

import java.awt.geom.{AffineTransform, Line2D}

case class Cut(p1: Point, p2: Point) extends Shape {
  def line2D:Line2D = new Line2D.Double(p1.point2D, p2.point2D)
  override val affineTransform: AffineTransform = idleTransform
  override def edgePoints: Seq[Point] = Seq(p1,p2)
}
