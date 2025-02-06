package basicGraphics;

abstract class GraphicsScene {
	protected GraphicsCanvas gc;

	GraphicsScene(GraphicsCanvas gc) {
		this.gc = gc;
	}

	void update(double delta) {
	}

	void draw() {
	}
}
