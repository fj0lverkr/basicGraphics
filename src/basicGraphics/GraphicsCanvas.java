package basicGraphics;

import javax.swing.*;

import drawables.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.List;

class GraphicsCanvas extends JComponent {
	private static final long serialVersionUID = -7420661734991984275L;
	
	private int width;
	private int height;
	private Color bgColor;
	private List<Drawable> drawables;
	
	public GraphicsCanvas(int w, int h, Color bgc) {
		width = w;
		height = h;
		bgColor = bgc;
	}
	
	public GraphicsCanvas(int w,int h) {
		this(w, h, Color.WHITE);
	}
	
	public List<Drawable> getDrawables() {
		return drawables;
	}
	
	public void setDrawables(List<Drawable> d) {
		drawables = d;
	}
	
	public void addDrawable(Drawable d) {
		drawables.add(d);
	}
	
	public void addDrawable(int index, Drawable d) {
		drawables.add(index, d);
	}
	
	public void removeDrawable(Drawable d) {
		drawables.remove(d);
	}
	
	public void removeDrawable(int index) {
		drawables.remove(index);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height); //Background color for window
		
		g2d.setRenderingHints(rh);
		g2d.setColor(bgColor);
		g2d.fill(bg);
		
		for(Drawable d : drawables) {
			d.draw(g2d);
		}
	}
}
