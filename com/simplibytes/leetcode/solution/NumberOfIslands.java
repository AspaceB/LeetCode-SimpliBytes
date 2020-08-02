/*
 * Copyright (c) 2020. Ashish Bansal
 */

package com.simplibytes.leetcode.solution;

/*Problem Description:
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
Example 1:
        Input:
        11110
        11010
        11000
        00000
        Output: 1
Example 2:
        Input:
        11000
        11000
        00100
        00011
        Output: 3
 */
public class NumberOfIslands {

    public NumberOfIslands() {
    }

    public int numberOfIslands(char[][] grid) {
        //Check whether grid is empty or not
        if (grid == null || grid.length == 0) {
            System.out.println("There is no island");
        }

        //Setting default number of islands as 0;
        int numberOfIslands = 0;

        //We need to iterate via two 'for' loops as need to traverse 2d Array
        //Row iteration
        for (int row = 0; row < grid.length; row++) {
            //Column Iteration
            for (int column = 0; column < grid[row].length; column++) {
                //We are only interested in cells values which has 1 i.e island..otherwise its water i.e 0
                if (grid[row][column] == '1') {
                    /*Using DFS Approach
                    The DFS algorithm is a recursive algorithm that uses the idea of backtracking.
                    It involves exhaustive searches of all the nodes by going ahead, if possible, else by backtracking.
                    Here, the word backtrack means that when you are moving forward and
                    there are no more nodes along the current path, you move backwards on the same path to find nodes to traverse.
                    All the nodes will be visited on the current path till
                    all the unvisited nodes have been traversed after which the next path will be selected.
                    */
                    numberOfIslands += checkForIslandDFS(grid, row, column);
                }
            }
        }
        System.out.println("Number of islands identified in the Grid " + numberOfIslands);
        return numberOfIslands;
    }

    private int checkForIslandDFS(char[][] grid, int row, int column) {

        //If the index of row or column is outside the grid boundary then it will be all water and no island
        //Also since it is recursive call internally we need to check whether the cell value is 0 or 1. If 0 no island.
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == '0') {
            return 0;
        }

        //This is done to check in case of multiple '1' in row or column..so existing one can be considered as water.
        grid[row][column] = '0';
        //Check for island to the left
        checkForIslandDFS(grid, row - 1, column);
        //Check for island to the right
        checkForIslandDFS(grid, row + 1, column);
        //Check for island to the up
        checkForIslandDFS(grid, row, column - 1);
        //Check for island to the down
        checkForIslandDFS(grid, row, column + 1);

        //This is returned as initially we entered in this function because a island (1) was identified.
        return 1;
    }

    //Running the code algorithm
    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        //Example 1
        char[][] grid1 = {{'1', '1', '1', '1', '0' }, {'1', '1', '0', '1', '0' }, {'1', '1', '0', '0', '0' }, {'0', '0', '0', '0', '0' }};
        //Example 2
        char[][] grid2 = {{'1', '1', '0', '0', '0' }, {'1', '1', '0', '0', '0' }, {'0', '0', '1', '0', '0' }, {'0', '0', '0', '1', '1' }};

        numberOfIslands.numberOfIslands(grid1);
        numberOfIslands.numberOfIslands(grid2);
    }
}
