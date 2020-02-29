import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JApplet;
import javax.swing.Timer;

public class TetrisThomasC extends JApplet implements KeyListener, ActionListener {
	int[][] grid = new int[30][15];
	BlockThomasC herro;
	boolean Right = false;
	boolean Left = false;
	boolean moveRight = false;
	boolean moveLeft = false;
	boolean GameOver = false;
	boolean FastMove = false;
	Timer t;
	public void init(){
		addKeyListener(this);
		setFocusable(true);
		herro = newBlock();
		herro.update();

    	t = new Timer(300,this);
    	t.start();
		
	}
	public void paint(Graphics g){
		super.paint(g);
		setSize(800,600);
		g.drawString("A and S for Left & Right, Arrow keys to rotate", 300, 10);
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col++){
				if(grid[row][col] == 0)
					g.setColor(Color.BLACK);
				else if(grid[row][col] == 1)
					g.setColor(Color.blue);
				else if(grid[row][col] == 2)
					g.setColor(Color.green);
				else
					g.setColor(Color.red);
				g.fillRect(col * 15, row * 15, 14, 14);
			}
		}
		if(GameOver)
			g.drawString("GAME OVER",500, 40);
	}
	public BlockThomasC newBlock(){
		int rand = (int)(Math.random() * 3);
		if(rand == 0)
			return new LongBlockThomasC(grid);
		else if(rand == 1)
			return new TriangleBlockThomasC(grid);
		else
			return new LBlockThomasC(grid);
	}
	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		int keyNum = k.getKeyCode();
		if(keyNum == KeyEvent.VK_RIGHT){
			Right =true;
		}
		if(keyNum == KeyEvent.VK_LEFT){
			Left = true;
		}

		if(keyNum == KeyEvent.VK_A){
			moveLeft = true;
		}
		if(keyNum == KeyEvent.VK_S){
			moveRight = true;
		}
	}
	public boolean rowDone(){
		for(int i = 0; i < grid[grid.length - 1].length;i++){
			if(grid[grid.length - 1][i] == 0){
				return false;
			}
		}
		return true;
	}
	public void allDown(){
		for(int row = grid.length - 1; row > 0; row--){
			grid[row] = grid[row - 1];
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int keyNum = arg0.getKeyCode();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!GameOver){
		if(!herro.isEnd())
			herro.tick();
		else{
			herro = newBlock();
			if(herro.isCollided()){
				GameOver = true;
			}
		}

		if(Right){
			herro.rotateRight();
			Right = false;
		}
		if(Left){
			herro.rotateLeft();
			Left = false;
		}
		if(moveRight){
			herro.moveRight();
			moveRight = false;
		}
		if(moveLeft){
			herro.moveLeft();
			moveLeft = false;
		}
		if(rowDone()){
			allDown();
		}
		repaint();
		}
	}
	
}
