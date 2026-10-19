class Solution {
    public int calPoints(String[] operations) {
        int total = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : operations) {
            if (s.equals("+")) {
                total += sum(stack);
            } else if (s.equals("D")) {
                total += doublePrev(stack);
            } else if (s.equals("C")) {
                total += clear(stack);
            } else {
                total += add(stack, s);
            }
            System.out.println(total);
        }
        return total;
    }

    private int sum(Deque<Integer> stack) {
        Integer a = stack.poll();
        Integer b = stack.poll();
        stack.push(b);
        stack.push(a);
        stack.push(a + b);
        return stack.peek();
    }

    private int doublePrev(Deque<Integer> stack) {
        stack.push(stack.peek() * 2);
        return stack.peek();
    }

    private int clear(Deque<Integer> stack) {
        Integer x = stack.poll();
        return -x;
    }

    private int add(Deque<Integer> stack, String s) {
        stack.push(Integer.valueOf(s));
        return stack.peek();
    }
}