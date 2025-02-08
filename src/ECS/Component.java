package ECS;

import java.io.Serializable;

public abstract class Component implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Entity linkedEntity;
	
	Entity getEntity() {
		return linkedEntity;
	}
	
	public abstract void update(double delta);

}
