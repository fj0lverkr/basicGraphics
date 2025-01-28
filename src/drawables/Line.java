package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line extends Drawable {
	private Line2D.Double l1;
	
	public Line(double x, double y, double ex, double ey, double size, Color color) {
		super(x, y, ex, ey, size, color);
		l1 = new Line2D.Double(x,y,ex,ey);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke((int)size));
		g2d.setColor(color);
		g2d.draw(l1);
	}

}
