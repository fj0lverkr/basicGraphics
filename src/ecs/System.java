package ecs;

public abstract class System {
	private String name;
	private Entity linkedEntity;
	
	public System (String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public abstract <T> T systemCallable();

}
