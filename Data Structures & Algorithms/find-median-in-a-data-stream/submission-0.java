class MedianFinder {

    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);
        largeHeap.offer(smallHeap.poll());

        if(largeHeap.size() > smallHeap.size()){
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() > largeHeap.size()){
            return smallHeap.peek();
        }

        return (smallHeap.peek() + largeHeap.peek())/2.0;
    }
}
