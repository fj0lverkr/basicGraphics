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
	protected boolean withOutline = false;
	protected boolean outlineInset = false;
	protected Color outlineColor = null;
	protected int outlineStrokeWidth = 1;
	
	protected Drawable(double x, double y, double w, double h, Color color) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = color;
	}
	
	protected Drawable(double x, double y, double w, double h, Color color, boolean oli, Color olc, int olw) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		this.color = color;
		withOutline = true;
		outlineInset = oli;
		outlineColor = olc;
		outlineStrokeWidth = olw;
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
	
}
