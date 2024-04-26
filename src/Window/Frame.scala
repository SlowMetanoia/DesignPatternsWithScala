package Window

import Shapes.{Point, Rectangle, Triangle}

import java.awt.{BorderLayout, Color, Dimension, Toolkit}
import java.io.File
import javax.swing.{BoxLayout, JButton, JFrame, JPanel}

object Frame extends JFrame{
  val actionHandler: ActionHandler.type = ActionHandler
  val data: ApplicationData.type = ApplicationData
  println("generating frame")
  val dimension: Dimension = Toolkit.getDefaultToolkit.getScreenSize
  val relativeScreenSize: (Double, Double)= (0.5, 0.5)
  val windowSize: (Int, Int) = (
    1300,
    700
  )
  setTitle("MyApp")
  setBackground(Color.BLACK)
  setVisible(true)
  setDefaultCloseOperation(1)
  setBounds(
    dimension.width/2 - windowSize._1/2,
    dimension.height/2 - windowSize._2/2,
    windowSize._1,
    windowSize._2
  )
  setLayout(new BorderLayout())
  add(new DrawerPanel(
    //(_: Int) => Seq(Shapes.Color(0.3, 0.4, 0.4), Shapes.Color(0.5, 0.5, 0.5), Shapes.Color(1,1,1)),
    Shapes.Color.defaultColorSet,
    () => Seq(
      Rectangle(400, 500),
      Rectangle(100, 200),
      Rectangle(200, 100),
      Triangle(Point(0,0),Point(100,40),(300,200))
    )
  ), BorderLayout.CENTER)
  setJMenuBar(ToolBar)
  revalidate()
}