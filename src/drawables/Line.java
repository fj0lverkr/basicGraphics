package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.List;

import javax.vecmath.Vector2d;

public class Line extends Drawable {
	private Path2D.Double p1;
	
	public Line(List<Vector2d> points, double size, Color color) {
		super(points, size, color);
		
		// Pad the Array to be at least 2 points
		while(points.size() <= 1) {
			points.add(new Vector2d());
		}
		p1 = new Path2D.Double();
		p1.moveTo(points.get(0).x, points.get(0).y);
		for(int i = 1; i < points.size(); i++) {
			p1.lineTo(points.get(i).x, points.get(i).y);
		}
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke((int)size));
		g2d.setColor(color);
		g2d.draw(p1);
	}

}
