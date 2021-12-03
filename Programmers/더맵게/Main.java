package Programmers.더맵게;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.solution(
                new int[]{1, 2},
                0
        ));
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int j : scoville) {
            queue.add(j);
        }

        int size = scoville.length;
        while (size != 1) {
            if (queue.peek() >= K) break;

            answer++;
            int x = queue.poll();
            int y = queue.poll();
            queue.add(x + (2 * y));
            size--;
        }

        return queue.peek() >= K ? answer : -1;
    }
}