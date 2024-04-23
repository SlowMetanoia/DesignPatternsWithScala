package Window

import java.io.File

sealed trait ApplicationAction

sealed trait FileAction extends ApplicationAction

object OpenFile extends FileAction
object SaveFile extends FileAction
object SaveFileAs extends FileAction

sealed trait DrawerAction extends ApplicationAction

case class FileChanged(file:File) extends ApplicationAction