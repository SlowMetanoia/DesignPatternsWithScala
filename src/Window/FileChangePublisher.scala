package Window

trait FileChangePublisher {
  var subscribers: Seq[FileChangeListener] = Seq.empty

  def subscribe(fileChangeListener: FileChangeListener): Unit =
    subscribers = subscribers.appended(fileChangeListener)

  def unsubscribe(fileChangeListener: FileChangeListener): Unit =
    subscribers = subscribers.filter(_ != fileChangeListener)

  def publish(path: String): Unit = subscribers.foreach(_.notify(path))
}
