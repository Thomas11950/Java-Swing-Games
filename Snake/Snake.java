import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	private boolean alive = true;
	ArrayList<Block> body;
	private String direction;
	public String getDirection(){
		return direction;
	}
	public Snake(){
		direction = "up";
		body = new ArrayList<Block>();
		body.add(new Block((int)(Math.random()*500), (int)(Math.random()*500)));
		body.add(new Block(body.get(0).getX(), body.get(0).getY()+10));
		body.add(new Block(body.get(0).getX(), body.get(0).getY()+20));
		body.add(new Block(body.get(0).getX(), body.get(0).getY()+30));
		body.add(new Block(body.get(0).getX(), body.get(0).getY()+40));
		body.add(new Block(body.get(0).getX(), body.get(0).getY()+50));
		body.add(new Block(body.get(0).getX(), body.get(0).getY()+60));
	}
	public void setDirection(String set){
		direction = set;
	}
	public void update(){
		if(direction.equals("up")){
			int x = body.get(0).getX();
			int y = body.get(0).getY();
			body.add(0,new Block(x,y-10));
			body.remove(body.size()-1);
		}
		if(direction.equals("down")){
			int x = body.get(0).getX();
			int y = body.get(0).getY();
			body.add(0,new Block(x,y+10));
			body.remove(body.size()-1);
		}
		if(direction.equals("right")){
			int x = body.get(0).getX();
			int y = body.get(0).getY();
			body.add(0,new Block(x+10,y));
			body.remove(body.size()-1);
		}
		if(direction.equals("left")){
			int x = body.get(0).getX();
			int y = body.get(0).getY();
			body.add(0,new Block(x-10,y));
			body.remove(body.size()-1);
		}
		for(int i = 1; i < body.size();i++){
			if(body.get(0).getX() == body.get(i).getX() && body.get(0).getY() == body.get(i).getY()){
				alive = false;
			}
		}
	}
	public Integer checkEat(ArrayList<Food> foods){
		for(int i = 0; i < foods.size();i++){
			if(foods.get(i).getX() == body.get(0).getX() && foods.get(i).getY() == body.get(0).getY()){
				if(body.size() == 1){
					if(direction.equals("up")){
						body.add(new Block(body.get(0).getX(), body.get(0).getY() + 10));
					}
					if(direction.equals("down")){
						body.add(new Block(body.get(0).getX(), body.get(0).getY() -10));
					}
					if(direction.equals("right")){
						body.add(new Block(body.get(0).getX() - 10, body.get(0).getY()));
					}
					if(direction.equals("left")){
						body.add(new Block(body.get(0).getX() + 10, body.get(0).getY()));
					}
				}
				else{
					int diffx = body.get(body.size() - 1).getX() - body.get(body.size() - 2).getX();
					int diffy = body.get(body.size() - 1).getY() - body.get(body.size() - 2).getY();
					body.add(new Block(body.get(body.size() - 1).getX() + diffx, body.get(body.size() -1).getY()));
				}
				return i;
			}
		}
		return -1;
	}
	public void draw(Graphics g){
		if(alive){
			for(Block b: body){
				g.fillRect(b.getX(), b.getY(), 10, 10);
			}
		}
	}
}
