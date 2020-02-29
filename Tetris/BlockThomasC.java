import java.awt.Color;
import java.awt.Color;
import java.util.ArrayList;
public abstract class BlockThomasC {
	
	protected int[][] blocks;
	protected int[][] grid;
	protected int color;
	public BlockThomasC(int[][] b, int f, int l, int color){
		grid = b;
		blocks = new int[f][l];
		this.color = color;
		
	}
	public void tick(){

		clear();
		for(int i = 0; i < blocks.length;i++){
			blocks[i][0]++;
		}
		update();
		
		
	}
	public void clear(){
		for(int i = 0; i < blocks.length;i++){
			grid[blocks[i][0]][blocks[i][1]] = 0;
		}
	}
	public boolean isEnd(){
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		clear();
		boolean canDo = true;
		for(int i = 0; i < dupl.length; i++){
			dupl[i][0]++;
			if(dupl[i][0] >= grid.length || dupl[i][0] < 0 || dupl[i][1] >= grid[0].length || dupl[i][1] < 0){
				canDo = false;
			}
			else if(grid[dupl[i][0]][dupl[i][1]] != 0)
				canDo = false;
		}
		update();
		return !canDo;
	}
	public void update(){
		for(int i = 0; i < blocks.length; i++){
			grid[blocks[i][0]][blocks[i][1]] = color;
		}
	}
	public void rotateLeft(){
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		clear();
		int[] center = dupl[0];
		for(int i = 0; i < dupl.length; i++){
			int temp = dupl[i][1];
			dupl[i][1] = (dupl[i][0] - center[0]) + center[1];
			dupl[i][0] = -(temp - center[1]) + center[0];
		}
		boolean canDo = true;
		for(int i = 0; i < dupl.length;i++){
			if(dupl[i][0] >= grid.length || dupl[i][0] < 0 || dupl[i][1] >= grid[0].length || dupl[i][1] < 0){
				canDo = false;
			}
			else if(grid[dupl[i][0]][dupl[i][1]] != 0)
				canDo = false;
		}
		if(canDo)
			blocks = dupl;
		update();
	}
	public void rotateRight(){
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		clear();
		int[] center = dupl[0];
		for(int i = 0; i < dupl.length; i++){
			int temp = dupl[i][1];
			dupl[i][1] = -(dupl[i][0] - center[0]) + center[1];
			dupl[i][0] = (temp - center[1]) + center[0];
		}
		boolean canDo = true;
		for(int i = 0; i < dupl.length;i++){
			if(dupl[i][0] >= grid.length || dupl[i][0] < 0 || dupl[i][1] >= grid[0].length || dupl[i][1] < 0){
				canDo = false;
			}
			else if(grid[dupl[i][0]][dupl[i][1]] != 0)
				canDo = false;
		}
		if(canDo)
			blocks = dupl;
		update();
	}
	public void moveRight(){
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		clear();
		boolean canDo = true;
		for(int i = 0; i < dupl.length;i++){
			dupl[i][1]++;
			if(dupl[i][0] >= grid.length || dupl[i][0] < 0 || dupl[i][1] >= grid[0].length || dupl[i][1] < 0){
				canDo = false;
			}
			else if(grid[dupl[i][0]][dupl[i][1]] != 0)
				canDo = false;
		}
		if(canDo)
			blocks = dupl;
		update();
	}
	public void moveLeft(){
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		clear();
		boolean canDo = true;
		for(int i = 0; i < dupl.length;i++){
			dupl[i][1]--;
			if(dupl[i][0] >= grid.length || dupl[i][0] < 0 || dupl[i][1] >= grid[0].length || dupl[i][1] < 0){
				canDo = false;
			}
			else if(grid[dupl[i][0]][dupl[i][1]] != 0)
				canDo = false;
		}
		if(canDo)
			blocks = dupl;
		update();
	}
	public boolean isCollided(){
		 for(int i = 0; i< blocks.length;i++){
			 if(grid[blocks[i][0]][blocks[i][1]] != 0){
				 update();
				 return true;
			 }
		 }
		 update();
		 return false;
	}
			
}
