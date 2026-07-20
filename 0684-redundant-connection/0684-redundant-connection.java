class Solution {
    int[] parent;
    int[] rank;

    int find_parent(int n){
        while(parent[n]!=n){
            n=parent[n];
        }

        return n;
    }

    boolean union(int[] n){
        int n1=n[0], n2=n[1];
        int p1 = find_parent(n1);
        int p2 = find_parent(n2);

        if(p1==p2)
            return false;

        if(rank[p1]>=rank[p2]){
            rank[p1]+=rank[p2];
            parent[p2] = p1;
        }
        else{
            rank[p2]+=rank[p1];
            parent[p1] = p2;
        }

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i=0; i<n; i++){
            if(!union(edges[i]))
                return edges[i];
        }

        return edges[0];
    }
}