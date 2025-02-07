package ECS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public List<Component> components;
	
	public Entity() {
		components = new ArrayList<Component>();
	}
	
	public boolean addComponent(Component c) {
		return components.add(c);
	}
	
	public boolean removeComponent(Component c) {
		return components.remove(c);
	}
}
