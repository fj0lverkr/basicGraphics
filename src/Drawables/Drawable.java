package Drawables;

import java.awt.Color;
import java.awt.Graphics2D;

public class Drawable {
	protected double x;
	protected double y;
	protected double ex;
	protected double ey;
	protected double size;
	protected double width;
	protected double height;
	protected Color color;
	
	protected Drawable(double x, double y, double w, double h, Color color) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = color;
	}
	
	protected Drawable(double x, double y, double size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	protected Drawable(double x, double y, double ex, double ey, double size, Color color) {
		this.x = x;
		this.y = y;
		this.ey = ey;
		this.ex = ex;
		this.size = size;
		this.color = color;
	}
	
	public void draw(Graphics2D g2d) {}
	
	public void drawWithOutline(Graphics2D g2d, Color color, int thickness) {}
	
	public void drawWithOutline(Graphics2D g2d, Color color, int thickness, boolean inset) {}
}
