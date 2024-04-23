package Shapes

import java.awt.geom.{AffineTransform, Line2D}
import scala.math.{acos, cos, sin, sqrt}

object ShapeOperations {
  def length(line: Line2D): Double = {
    val lx = line.getX2 - line.getX1
    val ly = line.getY2 - line.getY1
    sqrt(lx * lx + ly * ly)
  }
  def rotation(fi: Double): AffineTransform = {
    new AffineTransform(cos(fi), sin(fi), -sin(fi), cos(fi), 0, 0)
  }
  def rotation(cos: Double, sin: Double): AffineTransform = {
    new AffineTransform(cos, -sin, sin, cos, 0, 0)
  }
  def scale(nx: Double, my: Double): AffineTransform = {
    new AffineTransform(nx, 0, 0, my, 0, 0)
  }
  def shift(dx: Double, dy: Double): AffineTransform = {
    new AffineTransform(1, 0, 0, 1, dx, dy)
  }
  def concatenate(xsT:AffineTransform*):AffineTransform = {
    val result = new AffineTransform()
    xsT.foreach(result.concatenate)
    result
  }
  def applyTransformToLine(line:Line2D, xT:AffineTransform):Line2D = {
    new Line2D.Double(
      xT.transform(line.getP1,null),
      xT.transform(line.getP2,null)
    )
  }
  def getAT(baseLine:Line2D,imageLine:Line2D):AffineTransform = {
    val (x0, y0, x1, y1) = (
      baseLine.getX2 - baseLine.getX1,
      baseLine.getY2 - baseLine.getY1,
      imageLine.getX2 - imageLine.getX1,
      imageLine.getY2 - imageLine.getY1
    )
    val fi = {
      (if(x0*y1 - y0*x1 >= 0) 1 else -1)*acos((x0*x1 + y0*y1)/(length(baseLine)*length(imageLine)))
    }
    val xT = concatenate(
      shift(imageLine.getX1,imageLine.getY1),
      scale(length(imageLine)/length(baseLine),length(imageLine)/length(baseLine)),
      rotation(
        fi
      )
    )
    xT
  }
  def idleTransform = new AffineTransform()
}
