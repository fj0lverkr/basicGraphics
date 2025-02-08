package basicGraphics;

import java.util.List;

import ECS.Entity;

abstract class GraphicsScene extends Entity{
	private static final long serialVersionUID = 1L;
	protected GraphicsCanvas gc;
	private List<Entity> entities;

	
	GraphicsScene(GraphicsCanvas gc) {
		super(null, true);
		this.gc = gc;
	}

	public abstract void update(double delta);

	abstract void draw();
	
	protected void addEntity(Entity e) {
		if(e.uniqueInScene && getEntityByClass(e.getClass()) != null)
			return;
		entities.add(e);
	}
	
	protected Entity getEntityByClass(Class<? extends Entity> className) {
		for(Entity e : entities) {
			if(e.getClass() == className)
				return e;
		}
		return null;
	}
}
