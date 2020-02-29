import java.awt.Graphics;

public class Food {
	private int x,y;
	public Food(){
		x = (int)(Math.random()*50)*10;
		y = (int)(Math.random()*50)*10;
	}
	public void draw(Graphics g){
		g.fillRect(x, y, 10, 10);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
