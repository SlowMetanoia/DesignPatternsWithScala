package Window

trait FileChangeListener {
  def notify(path:String):Unit
}
