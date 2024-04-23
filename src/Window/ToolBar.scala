package Window

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JComboBox, JMenu, JMenuBar, JMenuItem, JPanel, JToolBar}

object ToolBar extends JMenuBar{
  println("generating toolbar")
  val file = new JMenu("File")
  val open = new JMenuItem("open")
  val save = new JMenuItem("save")
  val saveAs = new JMenuItem("save as...")
  open.addActionListener((e: ActionEvent) => ActionHandler.handle(OpenFile))
  save.addActionListener((e: ActionEvent) => ActionHandler.handle(SaveFile))
  saveAs.addActionListener((e: ActionEvent) => ActionHandler.handle(SaveFileAs))
  file.add(open)
  file.addSeparator()
  file.add(save)
  file.addSeparator()
  file.add(saveAs)
  add(file)
}
