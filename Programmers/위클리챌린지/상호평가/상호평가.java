package Programmers.위클리챌린지.상호평가;

public class 상호평가 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}}));
        System.out.println(solution.solution(new int[][]{{50, 90}, {50, 87}}));
        System.out.println(solution.solution(new int[][]{{70, 49, 90}, {68, 50, 38}, {73, 31, 100}}));
        System.out.println(solution.solution(new int[][]{
                {75, 50, 100},
                {75, 100, 20},
                {100, 100, 20}}));
    }

    static class Solution {
        public String solution(int[][] scores) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < scores.length; i++) {
                int minIdx = i;
                int maxIdx = i;
                int sum = 0;
                for (int j = 0; j < scores[0].length; j++) {
                    if (i != j && scores[minIdx][i] >= scores[j][i]) {
                        minIdx = j;
                    }

                    if (i != j && scores[maxIdx][i] <= scores[j][i]) {
                        maxIdx = j;
                    }

                    sum += scores[j][i];
                }

                if (minIdx == i) {
                    sum = (sum - scores[i][minIdx]) / (scores.length - 1);
                } else if (maxIdx == i) {
                    sum = (sum - scores[i][maxIdx]) / (scores.length - 1);
                } else {
                    sum = sum / scores.length;
                }

                answer.append(findGrade(sum));
            }

            return answer.toString();
        }

        private String findGrade(int sum) {
            if (sum >= 90) {
                return "A";
            } else if (sum >= 80) {
                return "B";
            } else if (sum >= 70) {
                return "C";
            } else if (sum >= 50) {
                return "D";
            } else {
                return "F";
            }
        }
    }
}
