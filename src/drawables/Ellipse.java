package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import basicGraphics.GraphicsCanvas;

public class Ellipse extends Drawable {

	private Ellipse2D.Double e1;

	public Ellipse(double x, double y, double w, double h, Color color, GraphicsCanvas parentCanvas) {
		super(x, y, w, h, color, parentCanvas);
		e1 = new Ellipse2D.Double(x, y, width, height);
	}

	public Ellipse(double x, double y, double w, double h, boolean fillShape, Color color, GraphicsCanvas parentCanvas) {
		super(x, y, w, h, fillShape, color, parentCanvas);
		e1 = new Ellipse2D.Double(x, y, width, height);
	}

	public Ellipse(double x, double y, double w, double h, Color color, boolean oli, Color olc, int olw, GraphicsCanvas parentCanvas) {
		super(x, y, w, h, color, oli, olc, olw, parentCanvas);
		e1 = new Ellipse2D.Double(x, y, width, height);
	}

	@Override
	public void draw(Graphics2D g2d) {
		if (withOutline) {
			if (outlineInset) {
				Ellipse e2 = new Ellipse(position.x, position.y, width, height, true, outlineColor, parentCanvas);

				e1.x = position.x + outlineStrokeWidth / 2;
				e1.y = position.y + outlineStrokeWidth / 2;
				e1.width = width - outlineStrokeWidth;
				e1.height = height - outlineStrokeWidth;

				e2.draw(g2d);
			} else {
				double offset = outlineStrokeWidth / 2;
				Ellipse e2 = new Ellipse(position.x - offset, position.y - offset, width + outlineStrokeWidth,
						height + outlineStrokeWidth, true, outlineColor, parentCanvas);

				e2.draw(g2d);
			}
		}
		drawBaseShape(g2d);
	}

	private void drawBaseShape(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke());
		g2d.setColor(color);
		if (fillShape) {
			g2d.fill(e1);
		} else {
			g2d.draw(e1);
		}
	}

}
