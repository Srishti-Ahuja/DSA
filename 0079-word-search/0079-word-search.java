class Solution {
    boolean dfs(char[][] board, String word, int x, int y, int idx){
        int n=board.length, m=board[0].length;

        if(idx==word.length()){
            System.out.println(x+" "+y+" "+idx);
            return true;
        }

        if(x>=n || y>=m || x<0 || y<0 || idx<0)
            return false;

        if(word.charAt(idx)!=board[x][y])
            return false;

        board[x][y]='#';
        
        boolean ans = dfs(board, word, x+1, y, idx+1) || dfs(board, word, x-1, y, idx+1) || dfs(board, word, x, y+1, idx+1) || dfs(board, word, x, y-1, idx+1);
        
        board[x][y]=word.charAt(idx);

        return ans;

    }
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }
}