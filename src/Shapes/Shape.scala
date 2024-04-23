package Shapes

import java.awt.geom.AffineTransform


/**
 * Фигура:
 * цвет
 * размер
 * точки
 * функция определения границы
 * функция определения нахождения точки внутри
 */
trait Shape extends Serializable{

  val affineTransform:AffineTransform
  def edgePoints: Seq[Point]
  def edges: Seq[Cut] = {
    val points = edgePoints
    points.sliding(2)
      .map(pair => Cut(pair(0), pair(1))).toSeq
      .appended(Cut(points.last, points.head))
  }

  def isInside(point: Point): Boolean = {
    val (x, y) = Point.unapply(point).get
    edges.count {
      case Cut(Point(xp, yp), Point(xp_prev, yp_prev)) =>
        ((yp <= y && y < yp_prev) || (yp_prev <= y && y < yp)) &&
          (x > (xp_prev - xp) * (y - yp) / (yp_prev - yp) + xp)
    } % 2 == 1
  }
  def sizes:(Double,Double) = {
    val points = edgePoints
    val x = points.maxBy(_.x).x - points.minBy(_.x).x
    val y = points.maxBy(_.y).y -  points.minBy(_.y).y
    (x, y)
  }
  def rect:Rectangle = {
    val (x,y) = sizes
    Rectangle(x, y)
  }
}

object Shape{
  def fromPoints(points: Iterable[Point]):Shape = new Shape {
    override def edgePoints: Seq[Point] = points.toSeq
    override val affineTransform: AffineTransform = new AffineTransform()
  }
}
