package basicGraphics;

import java.awt.Color;
import javax.swing.JFrame;

public class GraphicsWindow {
	
	private int width;
	private int height;
	private String title;
	private Color background;
	private JFrame f;
	private GraphicsCanvas gc;
	private boolean isRunning = false;
	
	public GraphicsWindow(int w, int h) {
		this(w, h, "default window", Color.WHITE);
	}
	
	public GraphicsWindow(int w, int h, String t) {
		this(w,h,t,Color.WHITE);
	}
	
	public GraphicsWindow(int w, int h, String t, Color bg) {
		width = w;
		height = h;
		title = t;
		background = bg;
		
		f = new JFrame();
		gc = new GraphicsCanvas(width, height, background);
		f.setSize(width, height);
		f.setTitle(title);
		f.add(gc);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		show();
		isRunning = true;
	}

	public void show() {
		f.setVisible(true);
	}
	
	public void hide() {
		f.setVisible(false);
	}
	
	public void drawDemo() {
		GraphicsDemo.drawDemo(gc);
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public void quit() {
		isRunning = false;
	}
}
