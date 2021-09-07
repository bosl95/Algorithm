package Programmers.등굣길;

import java.util.ArrayDeque;
import java.util.Deque;

public class 등굣길 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(4, 3, new int[][]{{2, 2}});
        System.out.println(result);
    }

    static class Solution {
        int[][] move = new int[][]{{1, 0}, {0, 1}};

        public int solution(int m, int n, int[][] puddles) {
            int[][] area = new int[m][n];

            // setting puddle
            for (int[] puddle : puddles) {
                area[puddle[0] - 1][puddle[1] - 1] = -1;
            }

            area[0][0] = 1;
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{0, 0});

            while (!deque.isEmpty()) {
                int[] xy = deque.pollFirst();
                int x = xy[0];
                int y = xy[1];

                if (area[x][y] > 1) continue;

                if (x > 0 && area[x - 1][y] != -1) {
                    area[x][y] += area[x - 1][y] % 1_000_000_007;
                }

                if (y > 0 && area[x][y - 1] != -1) {
                    area[x][y] += area[x][y - 1] % 1_000_000_007;
                }

                for (int[] mv : move) {
                    int mx = x + mv[0];
                    int my = y + mv[1];
                    if (0 <= mx && mx < m && 0 <= my && my < n && area[mx][my] == 0) {
                        deque.addLast(new int[]{mx, my});
                    }
                }
            }

            return area[m - 1][n - 1] % 1_000_000_007;
        }
    }
}
