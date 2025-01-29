package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import javax.vecmath.Vector2d;

public class Line extends Drawable {
	private Path2D.Double p1;
	
	public Line(Vector2d[]points, double size, Color color) {
		super(points, size, color);
		
		// Pad the Array to be at least 2 points
		while(points.length <= 1) {
			points = appendPoint(points.length, points, new Vector2d());
		}
		p1 = new Path2D.Double();
		p1.moveTo(points[0].x, points[0].y);
		for(int i = 1; i < points.length; i++) {
			p1.lineTo(points[i].x, points[i].y);
		}
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke((int)size));
		g2d.setColor(color);
		g2d.draw(p1);
	}
	
	public static Vector2d[] appendPoint(int n, Vector2d[] a, Vector2d p) {
		Vector2d[] newarr = new Vector2d[n + 1];
	    for (int i = 0; i < n; i++)
	    	newarr[i] = a[i];
	    newarr[n] = p;
	 
	    return newarr;
	}

}
