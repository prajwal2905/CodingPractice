package com.company;

/*
* Given a 2d matrix find the number of Islands, '1' denoting land and '0' denoting water
*
* Example 1:
* [ 1 1 1 1 0
*   1 1 0 1 0
*   1 1 0 0 0
*   1 0 0 0 0]
*
* Output: 1
*
* Example 1:
 * [ 1 1 0 0 0
 *   1 1 0 0 0
 *   0 0 1 0 0
 *   1 1 0 0 0]
 *
 * Output: 3
*
*/

public class HNumberOfIslands {

    public int numbIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for(int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0'; //Mark as visited Can also assign to any other number other than one
        dfs(grid, i+1, j); //Bottom
        dfs(grid, i-1, j); //Top
        dfs(grid, i, j+1); //Right
        dfs(grid, i, j-1); //Left
        //If diagonals needs to be considered.
        dfs(grid, i + 1, j + 1); //bottom-right side traversal
        dfs(grid, i - 1, j - 1); //top-left side traversal
        dfs(grid, i + 1, j - 1); //bottom-left side traversal
        dfs(grid, i - 1, j + 1); //top-right side traversal
        return 1;
    }
}
