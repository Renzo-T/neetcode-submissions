class Solution {
    public int[] getOrder(int[][] tasks) {
        // minHeap of enqueueTime
        // minHeap of processing time then index sorted
        // if 2nd heap is empty we set out current time to the top enqueTime
        // poll every thing in enqueue Time throw it in second heap
        // execute and as needed poll 1st heap and add to second heap
        PriorityQueue<int[]> enqueueTime = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        for (int i = 0; i < tasks.length; i++) {
            enqueueTime.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        PriorityQueue<int[]> processingTime = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) {
                    return a[2] - b[2]; // index tie breaker;
                } else {
                    return a[1] - b[1];
                }
            }
        );

        int[] order = new int[tasks.length];
        int orderIdx = 0;
        int time = 0;
        while (!enqueueTime.isEmpty() || !processingTime.isEmpty()) {
            if (processingTime.isEmpty()) {
                time = Math.max(time, enqueueTime.peek()[0]);
            }
            while (!enqueueTime.isEmpty() && enqueueTime.peek()[0] <= time) {
                processingTime.offer(enqueueTime.poll());
            }
            int[] task = processingTime.poll();
            time += task[1];
            order[orderIdx++] = task[2];
        }

        return order;
    }
}