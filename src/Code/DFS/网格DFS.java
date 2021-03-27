package Code.DFS;

public class 网格DFS {
    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int row, int col) {
        //校验规则
        if (!inArea(grid, row, col)) {
            return;
        }
        //不是岛屿直接返回
        if (grid[row][col] != '1') {
            return;
        }
        //是岛屿则标记为2，避免重复遍历
        grid[row][col] = '2';

        //遍历上下左右
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    private boolean inArea(char[][] grid, int row, int col) {
        int height = grid.length;
        int width = grid[0].length;
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
