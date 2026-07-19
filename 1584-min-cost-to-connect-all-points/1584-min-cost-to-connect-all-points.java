class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;

        HashMap<int[], List<Pair<Integer, int[]>>> adj = new HashMap<>(); 
        for(int i=0; i<n; i++){
            adj.put(points[i], new ArrayList<>());
            for(int j=0; j<n; j++){
                if(i!=j){
                    int val = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                    adj.get(points[i]).add(new Pair<>(val, points[j]));
                }
            }
        }

        HashSet<int[]> visited = new HashSet<>();
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.getKey(), b.getKey()));

        pq.add(new Pair<>(0,points[0]));
        
        int sum=0;
        while(!pq.isEmpty() && n>0){
            Pair<Integer, int[]> pair = pq.poll();
            int[] node = pair.getValue();

            if (visited.contains(node))
                continue;

            visited.add(node);
            sum += pair.getKey();

            for (Pair<Integer, int[]> next : adj.get(node)) {
                if (!visited.contains(next.getValue())) {
                    pq.add(next);
                }
            }
        }

        return sum;
    }
}