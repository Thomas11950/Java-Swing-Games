
public class Block {
	private int x,y;
	public Block(int x, int y){
		this.x = (x/10)*10;
		this.y = (y/10)*10;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
