import java.awt.Graphics;
import java.util.ArrayList;

public class BallThomasC {
	private int x,defaultx;
	private int y,defaulty;
	private boolean canRight = true,canLeft = true,canDown = true ,canUp = true;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSpeed() {
		return Speed;
	}
	public int getRadius() {
		return radius;
	}
	private int Speed = 3;
	private int radius = 10;
	public BallThomasC(int xin, int yin){
		x = xin;
		y = yin;
		defaultx = xin;
		defaulty = yin;
	}
	public void CreateBall(Graphics g){
		g.fillOval(x - radius, y-radius, radius * 2, radius * 2);
	}
	public void Move(int up, int down){
		x+=up;
		x-=down;
	}
	public void MoveRight(){
		if(canRight)
			x+=Speed;
	}
	public void MoveLeft(){
		if(canLeft)
			x-=Speed;
	}
	public void MoveUp(){
		if(canUp)
			y-=Speed;
	}
	public void MoveDown(){
		if(canDown)
			y+=Speed;
	}
	public void CheckForTag(BallThomasC b){
		if((b.getX() - 10 < x && b.getX() + 10 > x &&  b.getY() - 10 < y && b.getY() + 10 > y) && (250-x)/Math.abs(250-x) != (b.defaultx - 250)/Math.abs(b.defaultx-250)){
			x = defaultx;
			y = defaulty;
		}
	}
	public int getDefaultx() {
		return defaultx;
	}
	public int getDefaulty() {
		return defaulty;
	}
	public void detectObstacles(ArrayList<ObstacleThomasC> obs){
		canRight=true;
		canLeft=true;
		canUp=true;
		canDown=true;
		for(ObstacleThomasC o:obs){
			if(o.getX() + o.getWidth() +radius -4 < x && o.getX() + o.getWidth() + radius + 4 > x && o.getY() - radius < y && o.getY() + o.getHeight() + radius > y){
				canLeft = false;
			}
			if(o.getX()  - radius -4 < x && o.getX()  - radius + 4 > x && o.getY() - radius < y && o.getY() + o.getHeight() + radius > y){
				canRight = false;
			}
			if(o.getY()  - radius -4 < y && o.getY()  - radius + 4 > y && o.getX() - radius < x && o.getX() + o.getWidth() + radius > x){
				canDown = false;
			}
			if(o.getY() + o.getHeight() +radius -4 < y && o.getY() + o.getHeight() + radius + 4 > y && o.getX() - radius < x && o.getX() + o.getWidth() + radius > x){
				canUp = false;
			}
		}
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setDefaultx(int defaultx) {
		this.defaultx = defaultx;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setDefaulty(int defaulty) {
		this.defaulty = defaulty;
	}
	public void setCanRight(boolean canRight) {
		this.canRight = canRight;
	}
	public void setCanLeft(boolean canLeft) {
		this.canLeft = canLeft;
	}
	public void setCanDown(boolean canDown) {
		this.canDown = canDown;
	}
	public void setCanUp(boolean canUp) {
		this.canUp = canUp;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
