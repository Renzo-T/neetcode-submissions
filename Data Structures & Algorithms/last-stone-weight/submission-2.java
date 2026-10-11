class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() >= 2) {
            int stone = pq.poll() - pq.poll();
            if (stone > 0) {
                pq.offer(stone);
            }
        }

        if(pq.size() == 0) {
            return 0;
        }

        return pq.poll();
    }
}
