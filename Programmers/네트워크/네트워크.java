package Programmers.네트워크;

public class 네트워크 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution.solution(3, computers));
        System.out.println(solution.solution(3, computers2));
    }

    static class Solution {

        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visit = new boolean[n];

            for (int i = 0; i < computers.length; i++) {
                if (!visit[i]) {
                    answer++;
                    dfs(i, visit, computers);
                }
            }
            return answer;
        }

        private void dfs(int i, boolean[] visit, int[][] computers) {
            visit[i] = true;

            for (int j = 0; j < computers.length; j++) {
                if (!visit[j] && computers[i][j] == 1) {
                    dfs(j, visit, computers);
                }
            }
        }
    }
}
