package basicGraphics;

import java.awt.Color;

import javax.swing.JFrame;
import javax.vecmath.Vector2d;

import drawables.*;

public class GraphicsDrawer {

	public static void main(String[] args) {
		int w = 800;
		int h = 600;
		
		JFrame f = new JFrame();
		GraphicsCanvas gc = new GraphicsCanvas(w, h, Color.CYAN);
		f.setSize(w,h);
		f.setTitle("Basic Java Graphics");
		f.add(gc);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gc.setDrawables(createDrawables());
		f.setVisible(true);
	}
	
	private static Drawable[] createDrawables() {
		Vector2d[] p1 = new Vector2d[] {new Vector2d(0,95),new Vector2d(300,95)};
		return new Drawable[] {
				new Cloud(10, 15, 30, Color.YELLOW),
				new Cloud(100, 10, 35, Color.GREEN),
				new Ellipse(10, 100, 80, 80, Color.YELLOW, true, Color.BLACK, 10),
				new Ellipse(100, 100, 80, 80, Color.YELLOW, false, Color.BLACK, 10),
				new Ellipse(190, 100, 80, 80, Color.YELLOW),
				new Line(p1, 5, Color.BLACK)
		};
	}

}
