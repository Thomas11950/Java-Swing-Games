import java.util.ArrayList;

public class LongBlockThomasC extends BlockThomasC {

	public LongBlockThomasC(int[][] b) {
		super(b,5,2,(int)(Math.random() * 3) + 1);
		int rand2 = (int)(Math.random() * grid[0].length);
		blocks[0][0] = 2;
		blocks[0][1] = rand2;
		blocks[1][0] = 0;
		blocks[1][1] = rand2;
		blocks[2][0] = 1;
		blocks[2][1] = rand2;
		blocks[3][0] = 3;
		blocks[3][1] = rand2;
		blocks[4][0] = 4;
		blocks[4][1] = rand2;
		
		
	}
/*
	@Override
	public void rotateLeft() {
		// TODO Auto-generated method stub
		int[] center = blocks[2];
		if(!testLeft()){
			return;
		}
		else{
			clear();
			for(int i = 0; i < blocks.length; i++){

				int temp = blocks[i][1];
				blocks[i][1] = -(blocks[i][0] - center[0]) + center[1];
				blocks[i][0] = (temp - center[1]) + center[0];
			}
			update();
		}
	}

	@Override
	public void rotateRight() {
		// TODO Auto-generated method stub
		int[] center = blocks[2];
		if(!testRight()){
			System.out.println("keem");
			return;
		}
		else{
			clear();
			for(int i = 0; i < blocks.length; i++){
				int temp = blocks[i][1];
				blocks[i][1] = (blocks[i][0] - center[0]) + center[1];
				blocks[i][0] = -(temp - center[1]) + center[0];
			}
			update();
		}
	}

	
	public boolean testRight() {
		// TODO Auto-generated method stub
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		
		int[] center = dupl[2];
		if(center[1]  < 2 || center[1] > grid[0].length - 3 || center[0] < 2 || center[0] > grid.length - 3){
			return false;
		}
		else{
			for(int i = 0; i < dupl.length; i++){
				int temp = dupl[i][1];
				dupl[i][1] = (dupl[i][0] - center[0]) + center[1];
				dupl[i][0] = -(temp - center[1]) + center[0];
			}
		}
		for(int i = 0; i < blocks.length;i++){
			if(grid[dupl[i][0]][dupl[i][1]] != 0)
				return false;
		}
		return true;
	}

	
	public boolean testLeft(){
		// TODO Auto-generated method stub
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		
		int[] center = dupl[2];
		if(center[1]  < 2 || center[1] > grid[0].length - 3 || center[0] < 2 || center[0] > grid.length - 3){
			return false;
		}
		else{
			for(int i = 0; i < dupl.length; i++){
				int temp = dupl[i][1];
				dupl[i][1] = -(dupl[i][0] - center[0]) + center[1];
				dupl[i][0] = (temp - center[1]) + center[0];
			}
		}
		for(int i = 0; i < blocks.length;i++){
			if(grid[dupl[i][0]][dupl[i][1]] != 0)
				return false;
		}
		return true;
	}


	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}
	*/

}
