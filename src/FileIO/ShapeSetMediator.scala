package FileIO

import Shapes.Shape
import Window.ShapeSetChangeListener

class ShapeSetMediator(path:String) extends ShapeSetChangeListener{
  var shapeSet:Option[ShapeSet] = None
  def getFromFile:Seq[Shape] = {
    val shapes = FileReadWriter.readShapesFromFile(path).shapes
    shapeSet = Some(ShapeSet(shapes))
    shapes
  }
  def apply():()=>Seq[Shape] = {
    shapeSet.getOrElse(getFromFile)
    apply()
  }
  override def notify(shapes: Seq[Shape]): Unit = shapeSet = Some(ShapeSet(shapes))
  def saveToFile():Unit = shapeSet.foreach( set => FileReadWriter.writeShapesToFile(path, set))
}
