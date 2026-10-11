class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (arr1, arr2) -> arr2[1] - arr1[1]
        );
        if (a != 0) pq.offer(new int[]{'a', a});
        if (b != 0) pq.offer(new int[]{'b', b});
        if (c != 0) pq.offer(new int[]{'c', c});

        int lastChar = ' ';

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int[] entry = pq.poll();
            if (entry[0] == lastChar) {
                if (pq.isEmpty()) {
                    return sb.toString();
                }
                int[] entry2 = pq.poll();
                entry2[1]--;
                sb.append((char) entry2[0]);
                pq.offer(entry);
                if (entry2[1] > 0) {
                    pq.offer(entry2);
                }
                lastChar = entry2[0];
            } else {
                sb.append((char) entry[0]);
                entry[1]--;
                if (entry[1] > 0 && (pq.size() == 0 || entry[1] >= pq.peek()[1])) {
                    sb.append((char) entry[0]);
                    entry[1]--;
                }
                if (entry[1] > 0) {
                    pq.offer(entry);
                }
                lastChar = entry[0];
            }
        }

        return sb.toString();
    }
}