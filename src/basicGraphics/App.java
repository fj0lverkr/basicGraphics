package basicGraphics;

import java.awt.Color;

public class App {

	public static void main(String[] args) {
		final GraphicsWindow window = new GraphicsWindow(800, 600, "Demo Window", Color.CYAN);
		
		while(window.isRunning()) {
			window.drawDemo();
		}
	}

}
