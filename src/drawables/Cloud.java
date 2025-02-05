package drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Cloud extends Drawable{
	
	public Cloud(double x, double y, double size, Color color) {
		super(x, y, size, color);
	}

	@Override
	public void draw(Graphics2D g2d) {
		Ellipse2D.Double e1 = new Ellipse2D.Double(position.x,position.y,size,size);
		Ellipse2D.Double e2 = new Ellipse2D.Double(position.x+size*.35,position.y-size*.2,size*1.75,size*1.4);
		Ellipse2D.Double e3 = new Ellipse2D.Double(position.x+size*1.5,position.y+size*.15,size*.9,size*.9);
		Ellipse2D.Double e4 = new Ellipse2D.Double(position.x+size*1.8,position.y+size*.05,size*.3,size*.3);
		
		g2d.setColor(color);
		
		g2d.fill(e1);
		g2d.fill(e2);
		g2d.fill(e3);
		g2d.fill(e4);
	}
	
	@Override
	public double getWidth() {
		return 0;
	}
	
	@Override
	public double getHeight() {
		return 0;
	}

}
