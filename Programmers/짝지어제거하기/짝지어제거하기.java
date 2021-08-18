package Programmers.짝지어제거하기;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("baabaa"));
    }

    static class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop();
                    continue;
                }
                stack.push(s.charAt(i));
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}
