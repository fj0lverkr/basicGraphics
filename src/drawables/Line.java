package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Vector2d;

public class Line extends Drawable {
	private Path2D.Double p1;
	private List<Vector2d> bezierHandles = new ArrayList<Vector2d>();

	public Line(List<Vector2d> points, double size, Color color) {
		super(points, size, color);
		setPath();
	}

	public Line(List<Vector2d> points, List<Vector2d> curveHandles, double size, Color color) {
		super(points, size, color);
		bezierHandles = curveHandles;
		setPath();
	}

	private void setPath() {
		// Pad the Array to be at least 2 points
		while (points.size() <= 1) {
			points.add(new Vector2d());
		}
		p1 = new Path2D.Double();
		p1.moveTo(points.get(0).x, points.get(0).y);
		for (int i = 1; i < points.size(); i++) {
			if(bezierHandles.isEmpty()) {
				p1.lineTo(points.get(i).x, points.get(i).y);
			} else {
				//p1.curveTo(bezierHandles.get(i).x, , i, i, i, i);
			}
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke((int) size));
		g2d.setColor(color);
		g2d.draw(p1);
	}

}
