
public class BaseGameEntity extends Object{

	//variable
	protected boolean alive;
	protected double x,y;
	protected double velX,velY;
	protected double moveAngle, faceAngle;
	
	
	//acessor methods
	public boolean isAlive() {
		return alive;
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getVelX() {
		return velX;
	}
	
	public double getVelY() {
		return velY;
	}
	public double getFaceAngle() {
		return faceAngle;
	}
	public double getMoveAngle() {
		return moveAngle;
	}
	
	
	//mutador methods
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void incX(double x) {
		this.x += x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void incY(double y) {
		this.y += y;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public void incVelX(double velX) {
		this.velX += velX;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public void incVelY(double velY) {
		this.velY += velY;
	}
	public void setFaceAngle(double faceAngle) {
		this.faceAngle = faceAngle;
	}
	public void incFaceAngle(double faceAngle) {
		this.faceAngle += faceAngle;
	}
	public void setMoveAngle(double moveAngle) {
		this.moveAngle = moveAngle;
	}
	public void incMoveAngle(double moveAngle) {
		this.moveAngle += moveAngle;
	}
	
	//default constructor
	public BaseGameEntity() {
		
		setAlive(false);
		setX(0.0);
		setY(0.0);
		setVelX(0.0);
		setVelY(0.0);
		setMoveAngle(0.0);
		setFaceAngle(0.0);
	}
	
	
	
}
