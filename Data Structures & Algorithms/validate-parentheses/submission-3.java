class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || isNotValid(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private boolean isOpen(Character c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isNotValid(Character open, Character close) {
        return open == '(' && close != ')' || 
                open == '{' && close != '}' ||
                open == '[' && close != ']';
    }
}
