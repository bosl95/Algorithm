package Programmers.프린터;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            deque.add(i);
        }

        int count = 0;
        while (true) {
            int index = deque.pollFirst();
            int priority = priorities[index];

            LinkedList<Integer> copy = new LinkedList<>(deque);
            boolean pass = true;
            while (!copy.isEmpty()) {
                if (priority < priorities[copy.pollFirst()]) {
                    pass = false;
                    break;
                }
            }

            if (pass) {
                count++;
                if (index == location) return count;
            } else {
                deque.addLast(index);
            }
        }
    }
}
