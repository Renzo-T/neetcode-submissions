class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> q = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                Integer a = q.pop();
                Integer b = q.pop();
                q.add(a + b);
            } else if (token.equals("-")) {
                Integer a = q.pop();
                Integer b = q.pop();
                q.add(b - a);
            } else if (token.equals("*")) {
                Integer a = q.pop();
                Integer b = q.pop();
                q.add(a * b);
            } else if (token.equals("/")) {
                Integer a = q.pop();
                Integer b = q.pop();
                q.add(b / a);
            } else {
                q.add(Integer.valueOf(token));
            }
        }

        return q.pop();
    }
}
