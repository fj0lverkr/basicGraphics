package basicGraphics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Vector2d;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import drawables.Cloud;
import drawables.Drawable;
import drawables.Ellipse;
import drawables.Line;

class GraphicsDemo {
	static void drawDemo(GraphicsCanvas gc) {
		gc.setDrawables(createDrawables());
	}

	private static List<Drawable> createDrawables() {
		List<Vector2d> p1 = new ArrayList<Vector2d>(); // Points for straight line p1
		List<Vector2d> p2 = new ArrayList<Vector2d>(); // Points for curved line p2
		List<Pair<Vector2d, Vector2d>> h2 = new ArrayList<Pair<Vector2d, Vector2d>>(); // Bezier handles for line p2, h2
		List<Drawable> d = new ArrayList<Drawable>(); // List of Drawables to be sent to the GraphicsCanvas gc.

		// Points in a straight line
		p1.add(new Vector2d(0, 95));
		p1.add(new Vector2d(600, 95));
		p1.add(new Vector2d(600, 0));

		// Points in a straight line, to be curved
		p2.add(new Vector2d(10, 75));
		p2.add(new Vector2d(400, 75));

		// Handles for p2's curves, needs one per additional point in the Line object.
		// If there are too many than the additional ones are ignored.
		// If there aren't enough, a straight line is drawn in stead.
		h2.add(new MutablePair<Vector2d, Vector2d>(new Vector2d(17, 35), new Vector2d(500, 5)));
		h2.add(new MutablePair<Vector2d, Vector2d>(new Vector2d(999, 999), new Vector2d(999, 999))); // This one will be
																										// ignored,
																										// removing it
																										// does not
																										// change the
																										// drawing.

		d.add(new Cloud(10, 15, 30, Color.YELLOW));
		d.add(new Cloud(100, 10, 35, Color.GREEN));
		d.add(new Ellipse(10, 100, 80, 80, Color.YELLOW, true, Color.BLACK, 10));
		d.add(new Ellipse(100, 100, 80, 80, Color.YELLOW, false, Color.BLACK, 10));
		d.add(new Ellipse(190, 100, 80, 80, Color.YELLOW));
		d.add(new Ellipse(280, 100, 80, 80, true, Color.YELLOW));
		d.add(new Line(p1, 5, Color.RED));
		d.add(new Line(p2, h2, 3, Color.DARK_GRAY));

		return d;

	}
}
