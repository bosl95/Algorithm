package Programmers.가장먼노드;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}	));
    }

    static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            boolean[] visit = new boolean[n];
            boolean[][] edges = new boolean[n][n];

            for (int[] ints : edge) {
                int x = ints[0] - 1;
                int y = ints[1] - 1;
                edges[x][y] = true;
                edges[y][x] = true;
            }

            visit[0] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int now = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (edges[j][now] && !visit[j]) {
                            visit[j] = true;
                            queue.add(j);
                        }
                    }
                }
                answer = size;
            }

            return answer;
        }
    }
}
