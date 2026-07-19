class Solution {
    class Trie{
        HashMap<Character, Trie> children;
        boolean end;

        Trie(){
            children = new HashMap<>();
            end=false;
        }
    }

    List<String> res;

    void dfs(int r, int c, char[][] board, Trie node, String word, HashSet<Pair<Integer,Integer>> vis){
        int n=board.length, m=board[0].length;

        if(r<0 || c<0 || r==n || c==m || vis.contains(new Pair<>(r,c)))
            return;

        if(!node.children.containsKey(board[r][c]))
            return;
        node = node.children.get(board[r][c]);
        word = word + board[r][c];
        
        if(node.end){
            res.add(word);
            node.end=false;
        }

        vis.add(new Pair<>(r,c));

        dfs(r+1,c,board,node,word,vis);
        dfs(r-1,c,board,node,word,vis);
        dfs(r,c+1,board,node,word,vis);
        dfs(r,c-1,board,node,word,vis);

        vis.remove(new Pair<>(r,c));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word : words){
            Trie curr = root;
            for(int i=0; i<word.length(); i++){
                Character c = word.charAt(i);
                if(!curr.children.containsKey(c))
                    curr.children.put(c, new Trie());
                curr = curr.children.get(c);
            }

            curr.end=true;
        }

        res = new ArrayList<String>();
        HashSet<Pair<Integer,Integer>> vis = new HashSet<>();

        int n=board.length, m=board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dfs(i,j,board,root,"", vis);
            }
        }

        return res;
    }
}