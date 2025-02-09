package ecs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Component> components;
	private Entity parent;
	public boolean uniqueInScene;
	
	public Entity(boolean uniqueInScene) {
		components = new ArrayList<Component>();
		this.uniqueInScene = uniqueInScene;
	}

	public Entity() {
		this(false);
	}
	
	public Entity getParent() {
		return parent;
	}
	
	public boolean setParent(Entity p) {
		if(getParent() == null) {
			parent = p;
			return true;
		}
		
		return false;
	}

	public boolean addComponent(Component c) {
		if (getComponentByClass(c.getClass()) != null)
			return false;

		return components.add(c);
	}

	public boolean removeComponent(Component c) {
		if (getComponentByClass(c.getClass()) != null)
			return false;

		return components.remove(c);
	}

	public Component getComponentByClass(Class<? extends Component> className) {
		for (Component c : components) {
			if (c.getClass() == className) {
				return c;
			}
		}

		return null;
	}

	public abstract void update(double delta);

}
