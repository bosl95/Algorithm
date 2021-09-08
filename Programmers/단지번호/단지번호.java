package Programmers.단지번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호 {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    // 일단 프로그래머스 아님
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                area[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 1) {
                    count++;
                    answers.add(dfs(n, i, j, area));
                }
            }
        }
        Collections.sort(answers);
        System.out.println(count);
        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }

    private static int dfs(int n, int i, int j, int[][] area) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});

        int count = 0;
        while (!deque.isEmpty()) {
            int[] xy = deque.poll();
            if (area[xy[0]][xy[1]] == 0) continue;

            area[xy[0]][xy[1]] = 0;
            count++;

            for (int k = 0; k < 4; k++) {
                int mx = xy[0] + dx[k];
                int my = xy[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < n && area[mx][my] == 1) {
                    deque.addFirst(new int[]{mx, my});
                }
            }
        }
        return count;
    }
}
