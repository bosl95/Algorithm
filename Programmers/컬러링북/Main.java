package Programmers.컬러링북;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(
                6, 4,
//                new int[][]{
//                        {1, 1, 1, 0},
//                        {1, 2, 2, 0},
//                        {1, 0, 0, 1},
//                        {0, 0, 0, 1},
//                        {0, 0, 0, 3},
//                        {0, 0, 0, 3}
//                }
                new int[][]{
                        {1, 1, 1, 0},
                        {1, 1, 1, 0},
                        {0, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 1}}
        );
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class Solution {
    int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visit = new boolean[m][n];
        int[] answer = new int[2];
        this.m = m;
        this.n = n;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {
                    int maxSizeOfOneArea = checkArea(i, j, picture[i][j], visit, picture);
                    answer[0] += 1;
                    answer[1] = Math.max(answer[1], maxSizeOfOneArea);
                }
            }
        }

        return answer;
    }

    private int checkArea(int i, int j, int color, boolean[][] visit, int[][] picture) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        int count = 0;

        while (!deque.isEmpty()) {
            int[] xy = deque.pollFirst();
            if (visit[xy[0]][xy[1]]) continue;
            visit[xy[0]][xy[1]] = true;
            count++;

            for (int k = 0; k < 4; k++) {
                int mx = xy[0] + move[k][0];
                int my = xy[1] + move[k][1];
                if (validateIndex(mx, my) && !visit[mx][my] && picture[mx][my] == color) {
                    deque.add(new int[]{mx, my});
                }
            }
        }
        return count;
    }

    private boolean validateIndex(int mx, int my) {
        return 0 <= mx && mx < m && 0 <= my && my < n;
    }
}