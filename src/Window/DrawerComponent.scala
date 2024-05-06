package Window

import Shapes.{Color, Shape}
import com.typesafe.scalalogging.Logger

import java.awt.{Dimension, Graphics, Graphics2D, Rectangle}
import javax.swing.JComponent

class DrawerComponent(colorsGen: Int=>Seq[Color],
                      shapesGenerator: ()=>Seq[Shape]
                     ) extends JComponent{
  val logger = Logger("application")
  logger.debug("creating drawer component")
  setMaximumSize(new Dimension(5000,2000))
  setMinimumSize(new Dimension(500,500))
  setPreferredSize(new Dimension(4000,2000))
  setBackground(java.awt.Color.WHITE)
  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    logger.debug("painting")
    val g2d = g.asInstanceOf[Graphics2D]
    g2d.fill(new Rectangle(-100,-100,1000,1000))
    val shapes = shapesGenerator()
    logger.debug(s"number of shapes:${shapes.size}")
    val colors = colorsGen(shapes.size)
    logger.debug(s"number of colors:${shapes.size}")
    logger.debug(s"painting shapes:${shapes}")
    logger.debug(s"painting in:${colors}")
    shapes.zip(colors).foreach{
      case (shape, color) =>
        g2d.setTransform(shape.affineTransform)
        g2d.setColor(color.awtColor)
        shape.edges
          .map(_.line2D)
          .foreach(g2d.draw)
    }
  }
}
