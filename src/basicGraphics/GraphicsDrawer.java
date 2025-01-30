package basicGraphics;

import java.awt.Color;
import javax.swing.JFrame;

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
		
		//Replace the demo drawing with your logic
		GraphicsDemo.drawDemo(gc);

		f.setVisible(true);
	}
}
