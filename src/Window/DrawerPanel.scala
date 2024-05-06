package Window

import Shapes.{Color, Shape}
import com.typesafe.scalalogging.Logger

import java.awt.{Dimension, Graphics, Graphics2D, Rectangle}
import javax.swing.{BoxLayout, JComponent, JPanel}

class DrawerPanel(colorsGen: Int=>Seq[Color],
                  shapesGenerator: ()=>Seq[Shape]
                     ) extends JPanel with ShapeSetChangeListener {
  val logger: Logger = Logger("application")
  logger.debug("creating drawer panel")
  setBackground(java.awt.Color.BLACK)
  setLayout(new BoxLayout(this, BoxLayout.X_AXIS))
  val drawerComponent: DrawerComponent = new DrawerComponent(colorsGen, shapesGenerator)
  add(drawerComponent)
  repaint()
  override def notify(shapes: Seq[Shape]): Unit = drawerComponent.repaint()
}
