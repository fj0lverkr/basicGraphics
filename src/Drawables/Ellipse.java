package Drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Drawable {
	
	private Ellipse2D.Double e1;

	public Ellipse(double x, double y, double w, double h, Color color) {
		super(x, y, w, h, color);
		e1 = new Ellipse2D.Double(x,y,width, height);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke());
		g2d.setColor(color);
		g2d.fill(e1);
	}
	
	@Override
	public void drawWithOutline(Graphics2D g2d, Color color, int thickness, boolean inset) {
		if(inset) {
			draw(g2d);
			g2d.setColor(color);
			g2d.setStroke(new BasicStroke(thickness));
			g2d.draw(e1);
		}
	}

}
