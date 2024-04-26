package FileIO

import Shapes.{Point, Rectangle, Triangle}

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}


object FileReadWriter {
  def readShapesFromFile(path:String): ShapeSet = {
    val objectInputStream = new ObjectInputStream(new FileInputStream(path))
    objectInputStream.readObject().asInstanceOf[ShapeSet]
  }
  def writeShapesToFile(path:String, shapeSet: ShapeSet):Unit = {
    val objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))
    objectOutputStream.writeObject(shapeSet)
  }
}
