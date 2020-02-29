
public class LBlockThomasC extends BlockThomasC{
	public LBlockThomasC(int[][] b) {
		super(b,4,2,(int)(Math.random() * 3) + 1);
		int rand = (int)(Math.random() * (grid[0].length - 2));
		blocks[0][0] = 0;
		blocks[0][1] = rand;
		blocks[1][0] = 1;
		blocks[1][1] = rand;
		blocks[2][0] = 0;
		blocks[2][1] = rand + 1;
		blocks[3][0] = 0;
		blocks[3][1] = rand + 2;
				
	}
}
