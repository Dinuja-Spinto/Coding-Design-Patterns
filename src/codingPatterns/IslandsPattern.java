package codingPatterns;
//Islands (Matrix Traversal)
public class IslandsPattern {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    exploreIsland(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private void exploreIsland(char[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (row < 0 || row >= numRows || col < 0 || col >= numCols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // Mark the cell as visited

        // Explore neighboring cells (up, down, left, right)
        exploreIsland(grid, row - 1, col);
        exploreIsland(grid, row + 1, col);
        exploreIsland(grid, row, col - 1);
        exploreIsland(grid, row, col + 1);

    }

    public static void main(String[] args) {
        IslandsPattern islandsPattern = new IslandsPattern();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int numIslands = islandsPattern.numIslands(grid);
        System.out.println("Number of islands: " + numIslands);
    }
}

