class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> res = new HashMap<>();

        int[] copy = Arrays.copyOf(queries, queries.length);
        Arrays.sort(copy);
        Arrays.sort(intervals, (a, b) -> {
            int firstCompare = Integer.compare(a[0], b[0]);
            if (firstCompare != 0) {
                return firstCompare;
            }
            return Integer.compare(a[1], b[1]);
        });

        int i=0;
        PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>((a,b)-> Integer.compare(a.getKey(), b.getKey()));

        for(int q:copy){
            while(i<intervals.length && intervals[i][0]<=q){
                int l=intervals[i][0], r=intervals[i][1];
                heap.add(new Pair<>(r-l+1, r));
                i++;
            }

            while(!heap.isEmpty() && heap.peek().getValue()<q){
                heap.poll();
            }

            if(!heap.isEmpty())
                res.put(q, heap.peek().getKey());
            else
                res.put(q,-1);
        }

        int[] result = new int[queries.length];
        for(i=0; i<queries.length; i++)
            result[i] = res.get(queries[i]);

        return result;
    }
}