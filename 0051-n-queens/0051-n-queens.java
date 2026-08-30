class Solution {
    List<List<String>> res;
    HashMap<Integer, Boolean> col, diagPos, diagNeg;

    void solve(List<String> board, int row, int n){
        if(row==n){
            res.add(new ArrayList(board));
            return;
        }

        String rowStr = board.get(row);
        for(int i=0; i<n; i++){
            if(!col.getOrDefault(i,false) && !diagPos.getOrDefault(row+i, false) && !diagNeg.getOrDefault(row-i, false)){
                //setup
                rowStr = rowStr.substring(0,i) + "Q" + rowStr.substring(i+1,n);
                board.set(row, rowStr);
                col.put(i, true);
                diagPos.put(i+row, true);
                diagNeg.put(row-i, true);
                //recurse
                solve(board, row+1, n);
                //backtrack
                rowStr = rowStr.substring(0,i) + "." + rowStr.substring(i+1,n);
                board.set(row, rowStr);
                col.put(i, false);
                diagPos.put(i+row, false);
                diagNeg.put(row-i, false);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        res = new ArrayList<>();
        col = new HashMap<>();
        diagPos = new HashMap<>();
        diagNeg = new HashMap<>();

        for(int i=0; i<n; i++)
            board.add(".........");

        solve(board, 0, n);
        return res;
    }
}