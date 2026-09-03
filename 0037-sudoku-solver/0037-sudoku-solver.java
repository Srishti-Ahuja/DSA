class Solution {
    boolean row[][], col[][], sq[][];

    boolean solve(char[][] board, int r, int c){
        int n=board.length, m=board[0].length;

        if(r==9)
            return true;

        if(c==9)
            return solve(board, r+1, 0);

        if(board[r][c]!='.')
            return solve(board, r, c+1);

        for(int i=1; i<=9; i++){
            if(!col[c][i] && !row[r][i] && !sq[(r/3)*3 + (c/3)][i]){
                //setup
                board[r][c] = (char)(i+'0');
                row[r][i] = true;
                col[c][i] = true;
                sq[(r/3)*3 + (c/3)][i] = true;

                //recurse
                boolean ans = solve(board, r, c+1);
                if(ans)
                    return true;

                //backtrack
                board[r][c] = '.';
                row[r][i] = false;
                col[c][i] = false;
                sq[(r/3)*3 + (c/3)][i] = false;
            }
        }

        return false;
    }
    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        sq = new boolean[9][10];

        int n=board.length, m=board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (board[i][j] != '.') {
                    row[i][board[i][j]-'0'] = true;
                    col[j][board[i][j]-'0'] = true;
                    sq[(i/3)*3 + (j/3)][board[i][j]-'0'] = true;
                }
            }
        }

        solve(board, 0, 0);
    }
}