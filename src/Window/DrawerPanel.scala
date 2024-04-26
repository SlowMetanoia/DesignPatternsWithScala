package Window

import Shapes.{Color, Shape}

import java.awt.{Dimension, Graphics, Graphics2D, Rectangle}
import javax.swing.{BoxLayout, JComponent, JPanel}

class DrawerPanel(colorsGen: Int=>Seq[Color],
                  shapesGenerator: ()=>Seq[Shape]
                     ) extends JPanel with ShapeSetChangeListener {
  setBackground(java.awt.Color.BLACK)
  setLayout(new BoxLayout(this, BoxLayout.X_AXIS))
  val drawerComponent: JComponent = new JComponent {
    setMaximumSize(new Dimension(2000,2000))
    setMinimumSize(new Dimension(100,100))
    setPreferredSize(new Dimension(1200,1200))
    setBackground(java.awt.Color.WHITE)
    override def paintComponent(g: Graphics): Unit = {
      super.paintComponent(g)
      val g2d = g.asInstanceOf[Graphics2D]
      g2d.fill(new Rectangle(-100,-100,1000,1000))
      val shapes = shapesGenerator()
      val colors = colorsGen(shapes.size)
      println("[DEBUG]")
      shapes.zip(colors).foreach{
        case (shape, color) =>
          println(s"shape = ${shape}")
          println(s"color = ${color}")
          g2d.setTransform(shape.affineTransform)
          g2d.setColor(color.awtColor)
          shape.edges
            .map(_.line2D)
            .foreach(g2d.draw)
      }
    }
  }
  add(drawerComponent)
  repaint()
  override def notify(shapes: Seq[Shape]): Unit = drawerComponent.repaint()
}
