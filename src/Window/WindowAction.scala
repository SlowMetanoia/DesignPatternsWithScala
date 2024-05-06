package Window

import java.io.File

sealed trait ApplicationAction

sealed trait FileAction extends ApplicationAction

object OpenFile extends FileAction
object SaveFile extends FileAction
object SaveFileAs extends FileAction
case class FileChanged(path:String) extends FileAction
sealed trait DrawerAction extends ApplicationAction

