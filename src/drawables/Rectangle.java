package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Vector2d;

import basicGraphics.GraphicsCanvas;

public class Rectangle extends Drawable {
	private Rectangle2D.Double r1;

	public Rectangle(double x, double y, double width, double height, Color color, GraphicsCanvas parentCanvas) {
		super(x, y, width, height, color, parentCanvas);
		r1 = new Rectangle2D.Double(x, y, width, height);
	}

	public Rectangle(double x, double y, double size, Color color, GraphicsCanvas parentCanvas) {
		this(x, y, size, size, color, parentCanvas);
	}

	@Override
	public void update(double delta) {
		if (position.x >= parentCanvas.getWidth() - width || position.x < 0)
			velocity.x = -velocity.x;

		if (position.y >= parentCanvas.getHeight() - height || position.y < 0)
			velocity.y = -velocity.y;
		
		if(velocity.x != 0 && velocity.y != 0) {
			velocity.normalize();
			velocity.scale(delta);
			position.add(velocity);
		}

		r1 = new Rectangle2D.Double(position.x, position.y, width, height);
	}

	@Override
	public void draw(Graphics2D g2d) {
		drawBaseShape(g2d);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	private void drawBaseShape(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke());
		g2d.setColor(color);
		if (fillShape) {
			g2d.fill(r1);
		} else {
			g2d.draw(r1);
		}
	}
}
