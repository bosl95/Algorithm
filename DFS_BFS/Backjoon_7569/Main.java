package DFS_BFS.Backjoon_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int check = m * n * h;

        int[][][] tomato = new int[h][n][m];
        Deque<int[]> deque = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 0) continue;
                    tomato[k][i][j] = input;
                    if (tomato[k][i][j] == 1) deque.offer(new int[]{k, i, j});
                    check--;
                }
            }
        }

        System.out.println(bfs(tomato, deque, check, h, n, m));
    }

    private static int bfs(int[][][] tomato, Deque<int[]> deque, int check, int h, int n, int m) {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 0, 1, 0};
        int[] dz = {0, 0, 0, -1, 0, 1};
        int time = 0;
        int time_check = deque.size();

        while (!deque.isEmpty()) {
            int[] t = deque.poll();
            time_check--;
            for (int i = 0; i < 6; i++) {
                int mx = t[0] + dx[i];
                int my = t[1] + dy[i];
                int mz = t[2] + dz[i];
                if (0 <= mx && mx < h && 0 <= my && my < n && 0 <= mz && mz < m && tomato[mx][my][mz] == 0) {
                    tomato[mx][my][mz] = 1;
                    deque.offer(new int[]{mx, my, mz});
                    check--;
                }
            }
            if (time_check == 0) {
                time_check = deque.size();
                if (check + time_check == 0) return time;
                time++;
            }
        }

        return -1;
    }
}
