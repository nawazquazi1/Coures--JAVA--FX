package application;

public class GameOfLife {
	private int [][]grid;
	int M, N;
	
	public GameOfLife() {}
	
	public GameOfLife(int[][] grid) {
		this.grid = grid;
		M = grid.length;
		N = grid[0].length;
	}
	
	public int[][] nextGeneration(){
		int[][] future = new int[M][N];
		
		// Going through every cell
		for(int l=1;l<M-1;l++) {
			for(int m=1;m<N-1;m++) {
				// finding no Of Neighbours that are alive
				int aliveNeighbours = 0;
				for(int i=-1;i<=1;i++) {
					for(int j=-1;j<=1;j++) {
						aliveNeighbours += grid[l+i][m+j];
					}
				}
				
				// Removing itself as it was counted as a neighbour
				aliveNeighbours -= grid[l][m];
				
				// Rules of Life
				
					// Cell is lonely and dies
				if((grid[l][m] == 1) && (aliveNeighbours < 2))
					future[l][m] = 0;
				
					// Cell dies due to over population
				else if((grid[l][m] == 1) && (aliveNeighbours > 3))
					future[l][m] = 0;
				
					// A new cell is born
				else if((grid[l][m] == 0) && (aliveNeighbours == 3))
					future[l][m] = 1;
				
					// Remains the same
				future[l][m] = grid[l][m];
			}
		}
		for(int i=0;i<future.length;i++) {
			for(int j=0;j<future[0].length;j++) {
				grid[i][j] = future[i][j];
			}
		}
		return grid;
	}
}
















