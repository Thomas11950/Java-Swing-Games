import java.util.ArrayList;

public class TriangleBlockThomasC extends BlockThomasC {

	public TriangleBlockThomasC(int[][] b) {
		super(b,4,2,(int)(Math.random() * 3) + 1);
		int rand = (int)(Math.random() * (grid[0].length - 2));
		blocks[1][0] = 0;
		blocks[1][1] = rand;
		blocks[0][0] = 0;
		blocks[0][1] = rand + 1;
		blocks[2][0] = 1;
		blocks[2][1] = rand + 1;
		blocks[3][0] = 0;
		blocks[3][1] = rand + 2;
	}

	/*@Override
	public void rotateRight() {
		int[] center = blocks[1];
		if(!testRight()){
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
	public void rotateLeft() {
		int[] center = blocks[1];
		if(!testLeft()){
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
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		clear();
		int[] center = dupl[1];
		if(center[1]  == 0 || center[1] == grid[0].length - 1 || center[0]  == 0 || center[0] == grid.length - 1){
			update();
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
			if(grid[dupl[i][0]][dupl[i][1]] != 0){
				System.out.println(grid[dupl[i][0]][dupl[i][1]] != 0);
				update();
				return false;
			}
		}
		update();
		return true;
	}

	public boolean testLeft() {
		int[][] dupl = new int[blocks.length][blocks[0].length];
		for(int row = 0; row < blocks.length;row++){
			for(int col = 0; col < blocks[row].length; col++)
				dupl[row][col] = blocks[row][col];
		}
		
		int[] center = dupl[1];
		if(center[1]  == 0 || center[1] == grid[0].length - 1 || center[0]  == 0 || center[0] == grid.length - 1){
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
	*/



}
