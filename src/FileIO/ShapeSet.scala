package FileIO

import Shapes.Shape

case class ShapeSet (shapes:Seq[Shape]) extends AnyVal with Serializable
