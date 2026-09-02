class Solution {
    int[] res;

    void bfs(HashMap<Integer, List<Integer>> adj, int n){
        if(res[n-1]!=0)
            return;

        for(int i=1; i<=4; i++){
            boolean flag=false;
            for(int neighbor: adj.get(n)){
                if(res[neighbor-1]==i){
                    flag=true;
                    break;
                }
            }

            if(!flag){
                res[n-1]=i;
                return;
            }
        }
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        res = new int[n];

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<n; i++)
            adj.put(i+1, new ArrayList<>());

        for(int i=0; i<paths.length; i++){
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }

        for(int i=1; i<=n; i++)
            bfs(adj, i);

        return res;    
    }
}