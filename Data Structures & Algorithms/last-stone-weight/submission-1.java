class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (x, y) -> y-x
        );

        for (int stone : stones) {
            heap.add(stone);
        }

        while(heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            
            int stone = x-y;
            if (stone != 0) {
                heap.offer(stone);
            }
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
