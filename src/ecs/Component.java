package ecs;

import java.io.Serializable;

public abstract class Component implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected Entity linkedEntity;
	
	public Entity getEntity() {
		return linkedEntity;
	}
	
	public abstract void update(double delta);

}
