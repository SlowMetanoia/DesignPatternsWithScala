package Window

import Shapes.{Color, Shape}

import java.awt.{Dimension, Graphics, Graphics2D}
import javax.swing.JComponent

class DrawerComponent(colorsGen: Int=>Seq[Color], shapesGenerator: ()=>Seq[Shape]) extends JComponent{
  setMaximumSize(new Dimension(1000,1000))
  setMinimumSize(new Dimension(100,100))
  setPreferredSize(new Dimension(700,700))
  override def paintComponent(g: Graphics): Unit = {
    super.paintComponents(g)
    val g2d = g.asInstanceOf[Graphics2D]
    val shapes = shapesGenerator()
    val colors = colorsGen(shapes.size)
    shapes.zip(colors).foreach{
      case (shape, color) =>
        g2d.setTransform(shape.affineTransform)
        g2d.setColor(color.awtColor)
    }
  }
}
