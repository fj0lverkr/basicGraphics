package basicGraphics;

import javax.swing.JPanel;

import drawables.Drawable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

public class GraphicsCanvas extends JPanel {
	private static final long serialVersionUID = -7420661734991984275L;
	private List<Drawable> drawables;
	
	public GraphicsCanvas(int w, int h, Color bgc) {
		setPreferredSize(new Dimension(w, h));
		setBackground(bgc);
	}
	
	public GraphicsCanvas(int w,int h) {
		this(w, h, Color.WHITE);
	}
	
	public List<Drawable> getDrawables() {
		return drawables;
	}
	
	public void setDrawables(List<Drawable> d) {
		drawables = d;
		repaint();
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
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setRenderingHints(rh);
		
		if(drawables != null) {
			for(Drawable d : drawables) {
				d.draw(g2d);
			}
		}
	}
}
