class MedianFinder {
    PriorityQueue<Integer> small, big;

    public MedianFinder() {
        small = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        big = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        small.add(num);
        big.add(small.poll());

        if(big.size()-small.size()>1){
            small.add(big.poll());
        }
    }
    
    public double findMedian() {
        if(big.size()-small.size()==1)
            return big.peek();
        return (double)(small.peek()+big.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */