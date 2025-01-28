package drawables;

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
	
	public Ellipse(double x, double y, double w, double h, Color color, boolean oli, Color olc, int olw) {
		super(x,y,w,h,color,oli,olc,olw);
		e1 = new Ellipse2D.Double(x,y,width, height);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		if(withOutline) {
			if(outlineInset) {
				Ellipse e2 = new Ellipse(x, y, width, height, outlineColor);
				
				e1.x = x + outlineStrokeWidth / 2;
				e1.y = y + outlineStrokeWidth / 2;
				e1.width = width - outlineStrokeWidth;
				e1.height = height - outlineStrokeWidth;
		
				e2.draw(g2d);
			} else {
				double offset = outlineStrokeWidth / 2;
				Ellipse e2 = new Ellipse(x-offset, y-offset, width+outlineStrokeWidth, height+outlineStrokeWidth, outlineColor);
				
				e2.draw(g2d);
			}
		}
		drawBaseShape(g2d);
	}
	
	private void drawBaseShape(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke());
		g2d.setColor(color);
		g2d.fill(e1);
	}

}
