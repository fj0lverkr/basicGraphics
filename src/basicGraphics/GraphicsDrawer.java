package basicGraphics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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

	private static List<Drawable> createDrawables() {
		List<Vector2d> p1 = new ArrayList<Vector2d>();
		List<Drawable> d = new ArrayList<Drawable>();

		p1.add(new Vector2d(0,95));
		p1.add(new Vector2d(600,95));
		p1.add(new Vector2d(600,0));
		p1.add(new Vector2d(600,190));

		d.add(new Cloud(10, 15, 30, Color.YELLOW));
		d.add(new Cloud(100, 10, 35, Color.GREEN));
		d.add(new Ellipse(10, 100, 80, 80, Color.YELLOW, true, Color.BLACK, 10));
		d.add(new Ellipse(100, 100, 80, 80, Color.YELLOW, false, Color.BLACK, 10));
		d.add(new Ellipse(190, 100, 80, 80, Color.YELLOW));
		d.add(new Ellipse(280, 100, 80, 80,true, Color.YELLOW));
		d.add(new Line(p1, 5, Color.RED));

		return d;

	}

}
