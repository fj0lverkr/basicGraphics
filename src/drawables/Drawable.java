package drawables;

import javax.vecmath.Vector2d;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

public abstract class Drawable {
	public Vector2d position = new Vector2d();
	public Vector2d velocity = new Vector2d();
	protected double size;
	protected double width;
	protected double height;
	protected Color color;
	protected boolean withOutline = false;
	protected boolean outlineInset = false;
	protected Color outlineColor = null;
	protected int outlineStrokeWidth = 1;
	protected List<Vector2d> points;
	protected boolean closeLine = false;
	protected boolean fillShape = false;

	protected Drawable(double x, double y, double size, Color color) {
		position.x = x;
		position.y = y;
		this.size = size;
		this.color = color;
	}

	protected Drawable(double x, double y, double w, double h, Color color) {
		position.x = x;
		position.y = y;
		this.width = w;
		this.height = h;
		this.color = color;
	}

	protected Drawable(double x, double y, double w, double h, boolean fillShape, Color color) {
		this(x, y, w, h, color);
		this.fillShape = fillShape;
	}

	protected Drawable(double x, double y, double w, double h, Color color, boolean oli, Color olc, int olw) {
		this(x, y, w, h, true, color);
		withOutline = true;
		outlineInset = oli;
		outlineColor = olc;
		outlineStrokeWidth = olw;
	}

	protected Drawable(List<Vector2d> points, double size, Color color) {
		this(points.get(0).x, points.get(0).y, size, color);
		this.points = points;
	}

	protected Drawable(List<Vector2d> points, boolean closeLine, double size, Color color) {
		this(points.get(0).x, points.get(0).y, size, color);
		this.points = points;
		this.closeLine = closeLine;
	}

	protected Drawable(List<Vector2d> points, boolean closeLine, boolean fillShape, double size, Color color) {
		this(points.get(0).x, points.get(0).y, size, color);
		this.points = points;
		this.closeLine = closeLine;
		this.fillShape = fillShape;
	}

	public void draw(Graphics2D g2d) {
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
