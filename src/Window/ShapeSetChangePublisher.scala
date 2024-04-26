package Window

import Shapes.Shape

trait ShapeSetChangePublisher {
  var subscribers: Seq[ShapeSetChangeListener] = Seq.empty

  def subscribe(shapeSetChangeListener: ShapeSetChangeListener): Unit =
    subscribers = subscribers.appended(shapeSetChangeListener)

  def unsubscribe(shapeSetChangeListener: ShapeSetChangeListener): Unit =
    subscribers = subscribers.filter(_ != shapeSetChangeListener)

  def publish(shapes: Seq[Shape]): Unit = subscribers.foreach(_.notify(shapes))
}
