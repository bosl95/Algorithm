package DFS_BFS.Backjoon_7576;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int check = m * n;

        int[][] tomato = new int[n][m];
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 0) continue;
                if (tomato[i][j] == 1) deque.offer(new int[]{i, j});
                check--;
            }
        }

        System.out.print(bfs(tomato, deque, check, n, m));
    }

    private static int bfs(int[][] tomato, Deque<int[]> deque, int check, int n, int m) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int time = 0;
        int time_check = deque.size();

        while (!deque.isEmpty()) {
            int[] t = deque.poll();
            time_check--;
            for (int i = 0; i < 4; i++) {
                int mx = t[0] + dx[i];
                int my = t[1] + dy[i];
                if (0 <= mx && mx < n && 0 <= my && my < m && tomato[mx][my] == 0) {
                    tomato[mx][my] = 1;
                    deque.offer(new int[]{mx, my});
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
