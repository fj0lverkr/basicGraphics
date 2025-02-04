package basicGraphics;

abstract class GraphicsScene {
	protected GraphicsCanvas gc;
	
	GraphicsScene(GraphicsCanvas gc) {
		this.gc = gc;
	}
	
	void draw(double delta) {}
}
