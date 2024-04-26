package Window

import Shapes.Shape

trait ShapeSetChangeListener {
  def notify(shapes: Seq[Shape])
}
