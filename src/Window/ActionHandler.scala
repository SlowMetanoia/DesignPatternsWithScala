package Window

trait ActionHandler[T]{
  def handle(action: T):Unit
}


object ActionHandler extends ActionHandler[ApplicationAction]{
  override def handle(action: ApplicationAction): Unit = {
    action match {
      case action: FileAction => FileActionHandler.handle(action)
      case _ => throw new UnsupportedWindowActionException("Unsupported window action performed")
    }
  }
}
