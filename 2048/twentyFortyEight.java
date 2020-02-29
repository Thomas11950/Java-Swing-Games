import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JApplet;

public class twentyFortyEight extends JApplet implements KeyListener {
	private int cols = 4, rows = 4;
	Integer[][] board = {{null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null}};
	public void init(){
		addKeyListener(this);
		setFocusable(true);
	}	
	public void paint(Graphics g){
		super.paint(g);
		setSize(500,500);
		for(int row = 0; row<board.length;row++){
			for(int col = 0; col < board[row].length;col++){
				g.drawString(board[row][col] + "", col * 50 + 50, row *50 + 50);
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent event) {
		int code = event.getKeyCode();
		if(code == KeyEvent.VK_UP){
			for(int col = 0; col < cols; col++){
				for(int row = 1; row < rows; row++){
					int rowNum = row;
					while(rowNum > 0){

						String after = board[rowNum -1][col] +"";
						String before = board[rowNum][col] +"";
						if(board[rowNum-1][col] == null){
							board[rowNum-1][col] = board[rowNum][col];
							board[rowNum][col] = null;
						}
						if(after.equals(before) && board[rowNum][col] != null){
							board[rowNum-1][col]  = board[rowNum-1][col] * 2;
							board[rowNum][col] = null;
						}
						rowNum--;
					}
				}
			}
		}
		if(code == KeyEvent.VK_DOWN){
			for(int col = 0; col < cols; col++){
				for(int row = rows-2; row >= 0; row--){
					int rowNum = row;
					while(rowNum < rows - 1){
						String after = board[rowNum +1][col] +"";
						String before = board[rowNum][col] +"";
						if(board[rowNum+1][col] == null){
							board[rowNum+1][col] = board[rowNum][col];
							board[rowNum][col] = null;
						}
						if(board[rowNum][col] != null && after.equals(before)){
							System.out.println("herro");
							board[rowNum+1][col]  = board[rowNum+1][col] * 2;
							board[rowNum][col] = null;
						}
						rowNum++;
					}
				}
			}
		}
		if(code == KeyEvent.VK_LEFT){
			for(int row = 0; row < rows; row++){
				for(int col = 1; col < cols; col++){
					int colNum = col;
					while(colNum > 0){

						String after = board[row][colNum-1] +"";
						String before = board[row][colNum] +"";
						if(board[row][colNum-1] == null){
							board[row][colNum -1 ] = board[row][colNum];
							board[row][colNum] = null;
						}
						if(after.equals(before) && board[row][colNum] != null){
							System.out.println("herro");
							board[row][colNum -1]  = board[row][colNum -1] * 2;
							board[row][colNum] = null;
						}
						colNum--;
					}
				}
			}
		}
		if(code == KeyEvent.VK_RIGHT){
			for(int row = 0; row < rows; row++){
				for(int col = cols - 2; col >= 0; col--){
					int colNum = col;
					while(colNum < cols - 1){
						String after = board[row][colNum+1] +"";
						String before = board[row][colNum] +"";
						if(board[row][colNum+1] == null){
							board[row][colNum +1 ] = board[row][colNum];
							board[row][colNum] = null;
						}
						if(after.equals(before) && board[row][colNum] != null){
							System.out.println("herro");
							board[row][colNum +1]  = board[row][colNum +1] * 2;
							board[row][colNum] = null;
						}
						colNum++;
					}
				}
			}
		}
		if((code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT || code == KeyEvent.VK_DOWN || code == KeyEvent.VK_UP)){
			for(int row = 0; row < board.length; row++){
				for(int col = 0; col < board[row].length;col++){
					if(board[row][col] == null && (int)(Math.random() * 7) == 0){
						board[row][col] = ((int)(Math.random() * 2 + 1)) * 2;
					}
				}
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
