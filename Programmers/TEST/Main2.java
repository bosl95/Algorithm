package Programmers.TEST;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {
    public static void main(String[] args) {
        final Solution2 solution2 = new Solution2();
        final int result = solution2.solution(4, 3, new int[][]{{2, 2}});
        System.out.println(result);
    }
}

class Solution2 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] area = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            area[x][y] = -1;
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        area[0][0] = 1;

        while (!deque.isEmpty()) {
            int[] point = deque.pollFirst();
            int x = point[0];
            int y = point[1];
            if (area[x][y] > 1) continue;

            if (x > 0 && area[x - 1][y] != -1) {
                area[x][y] += area[x - 1][y] % 1000000007;
            }

            if (y > 0 && area[x][y - 1] != -1) {
                area[x][y] += area[x][y - 1] % 1000000007;
            }


            if (x + 1 < n && area[x + 1][y] == 0) {
                deque.addLast(new int[]{x + 1, y});
            }

            if (y + 1 < m && area[x][y + 1] == 0) {
                deque.addLast(new int[]{x, y + 1});
            }
        }

        return area[n - 1][m - 1] % 1000000007;
    }
}
