package com.leetcode.递归.岛屿问题;

public class NumIslands200 {


    /**
     * 本体思路：
     *
     * for( i : grid.length ){
     *     for( j : grid[0].length ){
     *         如果是水，就continue
     *         如果visit过，也continue
     *         dfs();
     *     }
     * }
     *
     * dfs(){
     *     开始各种淹没岛屿  left-1,right   left+1,right   left,right-1, left,right+1
     * }
     * 利用递归的方式用visited[i][j]记录涉及到的island，
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int nums= 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                if(visited[i][j]){
                    continue;
                }
                dfs(i,j,grid,visited);
                ++nums;
            }
        }
        return nums;
    }



    void dfs(int left,int right,char[][] grid,boolean[][] visited){
        if(left < 0 || right < 0 || left >= grid.length || right >= grid[0].length){
            return;
        }
        if(grid[left][right] == '0'){
            return;
        }
        if(visited[left][right]){
            return;
        }

        visited[left][right] = true;
        dfs(left-1,right,grid,visited);
        dfs(left+1,right,grid,visited);
        dfs(left,right-1,grid,visited);
        dfs(left,right+1,grid,visited);
    }
}
