import java.awt.Graphics;

public class FlagThomasC {
	private int x,y;
	private int defaultx,defaulty;
	private int oppdefx,oppdefy;
	private int points;
	private int scoreX,scoreY;
	private BallThomasC follow = null;
	private int score = 0;
	public FlagThomasC(int x, int y,int scoreX,int scoreY, int oppdefx, int oppdefy){
		defaultx = x;
		defaulty = y;
		this.x = x;
		this.y = y;
		this.scoreX = scoreX;
		this.scoreY = scoreY;
		this.oppdefx = oppdefx;
		this.oppdefy = oppdefy;
	}
	public void drawFlag(Graphics g){
		if(follow !=null){
			x=follow.getX();
			y=follow.getY();
		}
		g.fillRect(x-10, y-12, 10, 12);
		g.drawLine(x-10, y, x-10, y+12);
		g.drawString(score + "", scoreX, scoreY);
	}
	public void setFollow(BallThomasC b){
		follow=b;
	}
	public void checkProximity(BallThomasC b){
		if(b.getX() - 10 < x && b.getX() + 10 > x &&  b.getY() - 10 < y && b.getY() + 10 > y){
			follow = b;

		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void checkForFlagTouch(FlagThomasC f){
		if(f.getX() - 10 < x && f.getX() + 10 > x &&  f.getY() - 10 < y && f.getY() + 10 > y && oppdefx  == f.getX() && oppdefy == f.getY()){
			score++;
			x = defaultx;
			y = defaulty;
			follow = null;
			System.out.println(x+""+y);
		}
	}
	public void checkForTag(BallThomasC b){
		if(b.getX() - 10 < x && b.getX() + 10 > x &&  b.getY() - 10 < y && b.getY() + 10 > y&& (250-x)/Math.abs(250-x) == (250-defaultx)/Math.abs(250-defaultx) ){
			x = defaultx;
			y = defaulty;
			follow = null;
		}
	}
	public boolean taken(){
		return follow != null;
	}
}
