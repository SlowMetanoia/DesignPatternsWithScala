package Shapes

case class Triangle(p1:Point, p2:Point, p3:Point) extends Shape{
  override def edgePoints: Seq[Point] = Seq(p1,p2,p3)
}
