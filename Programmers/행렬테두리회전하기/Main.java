package Programmers.행렬테두리회전하기;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(
                6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}
        );
//        int[] result = solution.solution(
//                3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}
//        );
//        int[] result = solution.solution(
//                100, 97, new int[][]{{1, 1, 100, 97}}
//        );
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    int[][] area;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        area = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                area[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int min = rotateArea(x1, y1, x2, y2);
            answer[i] = min;
        }

        return answer;
    }

    int[][] mv = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    private int rotateArea(int x1, int y1, int x2, int y2) {
        int[][] edge = new int[][]{
                {x1, y1}, {x1, y2}, {x2, y2}, {x2, y1}
        };

        int i = 0;
        int pre = area[x1][y1];
        int min = pre;
        while (i < 4) {
            int x = edge[i][0], y = edge[i][1];

            int[] nextEdge = edge[(i + 1) % 4];
            while (true) {
                x += mv[i][0];
                y += mv[i][1];

                int next = area[x][y];
                area[x][y] = pre;
                pre = next;

                min = Math.min(min, next);

                if (x == nextEdge[0] && y == nextEdge[1]) break;
            }

            i++;
        }

        return min;
    }

    private void rotateArea2(int x1, int y1, int x2, int y2) {
        int rightTop = area[x1][y2];
        for (int i = y2; i > y1; i--) {
            area[x1][i] = area[x1][i - 1];
        }

        int rightBottom = area[x2][y2];
        for (int i = x2; i > x1 + 1; i--) {
            area[i][y2] = area[i - 1][y2];
        }
        area[x1 + 1][y2] = rightTop;

        int leftBottom = area[x2][y1];
        for (int i = y1; i < y2 - 1; i++) {
            area[x2][i] = area[x2][i + 1];
        }
        area[x2][y2 - 1] = rightBottom;

        for (int i = x1; i < x2 - 1; i++) {
            area[i][y1] = area[i + 1][y1];
        }
        area[x2 - 1][y1] = leftBottom;
    }
}
