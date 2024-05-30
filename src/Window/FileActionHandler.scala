package Window

import javax.swing.JFileChooser

object FileActionHandler extends ActionHandler[FileAction] {
  override def handle(action: FileAction): Unit = {
    action match {
      case action: FileAction =>
        action match {
          case OpenFile => openFile()
          case SaveFile => saveFile()
          case SaveFileAs => saveFileAs()
          case FileChanged(file) =>
        }
    }
    def openFile(): Unit = {
      val jFileChooser = new JFileChooser()
      jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY)
      val result = jFileChooser.showOpenDialog(Frame())
      if(result == JFileChooser.APPROVE_OPTION) {
        val selected = jFileChooser.getSelectedFile
        //ApplicationData.file = Some(selected)
        ActionHandler.handle(FileChanged(selected.getPath))
      }
    }
    def fileChanged() = ???
    def saveFile() = ???
    def saveFileAs() = ???
  }
}
