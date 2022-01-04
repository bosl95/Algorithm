package Programmers.순위;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}

class Solution {

    public static final int PLAYER_COUNT = 10000;

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], PLAYER_COUNT);
        }

        for (int i = 0; i < results.length; i++) {
            final int a = results[i][0]; // 부모
            final int b = results[i][1]; // 자식
            graph[a][b] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            // 시작 정점
            for (int j = 1; j < n + 1; j++) {
                // 끝 정점
                for (int k = 1; k < n + 1; k++) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int count = 0;

            // 순서를 돌면서
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] < PLAYER_COUNT || graph[j][i] < PLAYER_COUNT) // i -> j 방문 가능하거나 j -> i 방문 가능하면
                    count++;
            }

            if (count == n - 1) answer++;
        }

        return answer;
    }

}
