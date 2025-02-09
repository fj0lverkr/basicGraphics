package ecs.entities;

import java.util.List;

import basicGraphics.GraphicsCanvas;
import ecs.Entity;

public abstract class GraphicsScene extends Entity{
	private static final long serialVersionUID = 1L;
	protected GraphicsCanvas gc;
	private List<Entity> entities;

	
	public GraphicsScene(GraphicsCanvas gc) {
		super(true);
		this.gc = gc;
	}

	public abstract void update(double delta);

	public abstract void draw();
	
	public void addEntity(Entity e) {
		if(e.uniqueInScene && getEntityByClass(e.getClass()) != null)
			return;
		if(e.setParent(this))
			entities.add(e);
	}
	
	public Entity getEntityByClass(Class<? extends Entity> className) {
		for(Entity e : entities) {
			if(e.getClass() == className)
				return e;
		}
		return null;
	}
}
