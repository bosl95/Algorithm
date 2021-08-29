package Programmers.정수삼각형;

public class 정수삼각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    static class Solution {
        public int solution(int[][] triangle) {
            int n = triangle.length;

            if (n == 1) return triangle[0][0];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (j == 0) {
                        triangle[i][j] += triangle[i - 1][j];
                    } else if (j == triangle[i].length - 1) {
                        triangle[i][j] += triangle[i - 1][j - 1];
                    } else {
                        triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                    }
                }
            }

            int answer = triangle[n - 1][0];
            for (int i = 1; i < triangle[n - 1].length; i++) {
                if (answer < triangle[n - 1][i]) {
                    answer = triangle[n - 1][i];
                }
            }

            return answer;
        }
    }
}
