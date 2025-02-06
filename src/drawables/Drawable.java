package drawables;

import javax.vecmath.Vector2d;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import basicGraphics.GraphicsCanvas;

public abstract class Drawable {
	public Vector2d position = new Vector2d();
	public Vector2d velocity = new Vector2d();
	protected GraphicsCanvas parentCanvas;
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
	
	protected Drawable(double x, double y, double w, double h, Color color, GraphicsCanvas parentCanvas) {
		position.x = x;
		position.y = y;
		this.width = w;
		this.height = h;
		this.color = color;
		this.parentCanvas = parentCanvas;
	}

	protected Drawable(double x, double y, double size, Color color, GraphicsCanvas parentCanvas) {
		this(x, y, size, size, color, parentCanvas);
		this.size = size;
		this.parentCanvas = parentCanvas;
	}

	protected Drawable(double x, double y, double w, double h, boolean fillShape, Color color, GraphicsCanvas parentCanvas) {
		this(x, y, w, h, color, parentCanvas);
		this.fillShape = fillShape;
	}

	protected Drawable(double x, double y, double w, double h, Color color, boolean oli, Color olc, int olw, GraphicsCanvas parentCanvas) {
		this(x, y, w, h, true, color, parentCanvas);
		withOutline = true;
		outlineInset = oli;
		outlineColor = olc;
		outlineStrokeWidth = olw;
	}

	protected Drawable(List<Vector2d> points, double size, Color color, GraphicsCanvas parentCanvas) {
		this(points.get(0).x, points.get(0).y, size, color, parentCanvas);
		this.points = points;
	}

	protected Drawable(List<Vector2d> points, boolean closeLine, double size, Color color, GraphicsCanvas parentCanvas) {
		this(points.get(0).x, points.get(0).y, size, color, parentCanvas);
		this.points = points;
		this.closeLine = closeLine;
	}

	protected Drawable(List<Vector2d> points, boolean closeLine, boolean fillShape, double size, Color color, GraphicsCanvas parentCanvas) {
		this(points.get(0).x, points.get(0).y, size, color, parentCanvas);
		this.points = points;
		this.closeLine = closeLine;
		this.fillShape = fillShape;
	}

	public void update(double delta) {
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
