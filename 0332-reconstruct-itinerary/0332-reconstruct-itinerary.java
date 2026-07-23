class Solution {
    List<String> res;

    void dfs(HashMap<String, PriorityQueue<String>> adj, String src) {

        PriorityQueue<String> neighbors = adj.get(src);
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(adj, neighbors.poll());
        }
        res.addFirst(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        for(int i=0; i<tickets.size(); i++){
            if(!adj.containsKey(tickets.get(i).get(0)))
                adj.put(tickets.get(i).get(0), new PriorityQueue<>());
            adj.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }

        res = new ArrayList<>();
    
        dfs(adj, "JFK");

        return res;
    }
}