package ECS.components;

import javax.vecmath.Vector2d;

import ECS.Component;

public class TransformComponent extends Component {
	private static final long serialVersionUID = 1L;

	private Vector2d position;
	private double rotation;
	private Vector2d scale;

	public TransformComponent(Vector2d pos, Vector2d scale, double rotation) {
		this.position = pos;
		this.rotation = rotation;
		this.scale = scale;
	}

	public TransformComponent(Vector2d pos) {
		this(pos, new Vector2d(1, 1), 0);
	}

	public TransformComponent(Vector2d pos, Vector2d scale) {
		this(pos, scale, 0);
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub

	}

	public Vector2d getPosition() {
		return position;
	}

	public Vector2d getScale() {
		return scale;
	}

	public double getRotationRad() {
		return rotation;
	}

	public double getRotationDeg() {
		return Math.toDegrees(rotation);
	}
	
	public void setPositionX(double x) {
		position.x = x;
	}
	
	public void setPositionY(double y) {
		position.y = y;
	}
	
	public void setPosition(Vector2d pos) {
		position = pos;
	}
	
	public void setScaleX(double x) {
		scale.x = x;
	}
	
	public void setScaleY(double y) {
		scale.y = y;
	}
	
	public void setScale(Vector2d s) {
		scale = s;
	}
	
	public void setRotationRad (double r) {
		rotation = r;
	}
	
	public void setRotationDeg(double d) {
		rotation = Math.toRadians(d);
	}
}
