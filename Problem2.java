/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(4^M*N)

The idea is to perform DFS across each point in the matrix and once it cannot find the word backtrack by making the visited array false.
**/
class Solution {
    int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
    int m;
    int n;
    int[][] visited;
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length < 1)
            return false;
        
        if(board[0].length < 1)
            return false;
        
        if(word == null || word == "")
            return true;
        
        m = board.length;
        n = board[0].length;
        
        visited = new int[m][n];
        
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(dfs(board, word,i,j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j){
        if(word.length() == 0)
            return false;
        
        if(visited[i][j] == 1)
            return false;
        
        if(word.charAt(0) == board[i][j] && visited[i][j] != 1){
            visited[i][j] = 1;
            
            if(word.length() == 1)
                return true;
            
            for(int[] dir : dirs){
                int row = i + dir[0];
                int col = j + dir[1];
    
                if(row >= 0 && row < m && col >= 0  && col <n){
                    if(dfs(board,word.substring(1),row,col))
                        return true;
                }
            }
            visited[i][j] = 0;
        }
        return false;
    }
}
