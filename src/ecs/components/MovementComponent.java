package ecs.components;

import javax.vecmath.Vector2d;

import drawables.Drawable;
import ecs.Component;

public class MovementComponent extends Component {
	private static final long serialVersionUID = 1L;

	private Vector2d velocity;
	private double speed;
	
	public MovementComponent(Vector2d velocity, double speed) {
		this.velocity = velocity;
		this.speed =  speed;
	}
	
	public MovementComponent() {
		this(new Vector2d(), 0);
	}

	@Override
	public void update(double delta) {
		if(linkedEntity == null)
			return;
		TransformComponent transform = (TransformComponent) linkedEntity.getComponentByClass(TransformComponent.class);
		Drawable drawable = (Drawable) linkedEntity.getComponentByClass(Drawable.class);
		if(transform == null || drawable == null)
			return;
		
		if (transform.position.x >= drawable.parentCanvas.getWidth() - transform.width || transform.position.x < 0)
			velocity.x = -velocity.x;

		if (transform.position.y >= drawable.parentCanvas.getHeight() - transform.height || transform.position.y < 0)
			velocity.y = -velocity.y;
		
		if(velocity.x != 0 || velocity.y != 0) {
			velocity.normalize();
			velocity.scale(delta);
			transform.position.add(velocity);
		}
	}

	public Vector2d getVelocity() {
		return velocity;
	}

	public double getVelocityX() {
		return velocity.x;
	}

	public double getVelocityY() {
		return velocity.y;
	}

	public double getSpeed() {
		return speed;
	}
	
	public void setVelocity(Vector2d v) {
		velocity = v;
	}
	
	public void setVelocityX(double x) {
		velocity.x = x;
	}
	
	public void setVelocityY(double y) {
		velocity.y = y;
	}
	
	public void setSpeed(double s) {
		speed = s;
	}

}
