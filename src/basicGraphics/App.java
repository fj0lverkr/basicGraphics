package basicGraphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class App {
	private static final int TARGET_FPS = 60;
	private static final int FRAME_DELAY = Math.floorDiv(1000, TARGET_FPS);

	public static void main(String[] args) {
		final GraphicsWindow window = new GraphicsWindow(800, 600, "Demo Window", Color.CYAN);
		new Timer(FRAME_DELAY, new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		    	run(window);
		     }
		  }).start();
	}
	
	private static void run(GraphicsWindow window) {
 		if(window.isRunning()) {
			window.drawDemo(1000/TARGET_FPS, false);
		}
	}

}
