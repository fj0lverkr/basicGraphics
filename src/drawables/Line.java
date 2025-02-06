package drawables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Vector2d;

import org.apache.commons.lang3.tuple.Pair;

import basicGraphics.GraphicsCanvas;

public class Line extends Drawable {
	private Path2D.Double p1;
	private List<Pair<Vector2d, Vector2d>> bezierHandles = new ArrayList<Pair<Vector2d, Vector2d>>();

	public Line(List<Vector2d> points, double size, Color color, GraphicsCanvas parentCanvas) {
		super(points, size, color, parentCanvas);
		setPath();
	}

	public Line(List<Vector2d> points, List<Pair<Vector2d, Vector2d>> curveHandles, double size, Color color, GraphicsCanvas parentCanvas) {
		super(points, size, color, parentCanvas);
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
			if (bezierHandles.isEmpty()) {
				p1.lineTo(points.get(i).x, points.get(i).y);
			} else {
				if (bezierHandles.size() >= points.size()) {
					Vector2d h1 = bezierHandles.get(i - 1).getLeft();
					Vector2d h2 = bezierHandles.get(i - 1).getRight();
					p1.curveTo(h1.x, h1.y, h2.x, h2.y, points.get(i).x, points.get(i).y);
				} else {
					int diff = points.size() - bezierHandles.size();
					if (i-1 >= diff) {
						p1.lineTo(points.get(i).x, points.get(i).y);
					} else {
						Vector2d h1 = bezierHandles.get(i - 1).getLeft();
						Vector2d h2 = bezierHandles.get(i - 1).getRight();
						p1.curveTo(h1.x, h1.y, h2.x, h2.y, points.get(i).x, points.get(i).y);
					}
				}
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
