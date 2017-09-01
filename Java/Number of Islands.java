public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public void DFS(boolean[][] grid, int i, int j) {
        int x = i, y = j;
        grid[x][y] = false;
        if (x > 0 && grid[x - 1][y]) {
            DFS(grid, x - 1, y);
        }
        if (x < grid.length - 1 && grid[x + 1][y]) {
            DFS(grid, x + 1, y);
        }
        if (y > 0 && grid[x][y - 1]) {
            DFS(grid, x, y - 1);
        }
        if (y < grid[x].length - 1 && grid[x][y + 1]) {
            DFS(grid, x, y + 1);
        }
    }
     
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == true) {
                    DFS(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
}