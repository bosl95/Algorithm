package Programmers.주식가격;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] results = solution.solution(new int[]{1, 2, 3, 2, 3});
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] seconds = new int[prices.length];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            while (!queue.isEmpty() && prices[queue.peekLast()] > prices[i]) {
                Integer index = queue.pollLast();
                seconds[index] = i - index;
            }
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer index = queue.pollLast();
            seconds[index] = prices.length - index - 1;
        }

        return seconds;
    }
}
