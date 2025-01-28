package basicGraphics;

import javax.swing.*;

import Drawables.*;

import java.awt.*;
import java.awt.geom.*;

class GraphicsCanvas extends JComponent {
	private static final long serialVersionUID = -7420661734991984275L;
	
	private int width;
	private int height;
	private Color bgColor;
	private Drawable[] drawables;
	
	public GraphicsCanvas(int w, int h, Color bgc, Drawable[] d) {
		width = w;
		height = h;
		bgColor = bgc;
		drawables = d;
	}
	
	public GraphicsCanvas(int w,int h, Drawable[] d) {
		this(w, h, Color.WHITE, d);
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
