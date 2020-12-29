package DFS_BFS.Backjoon_2178;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                if (temp.charAt(j) == '0') visit[i][j] = true;
            }
        }

        int[][] queue = new int[n * m][3];
        int front = 0;
        int rear = 1;

        queue[front][2] = 1;
        visit[0][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (front <= rear) {
            for (int i = 0; i < 4; i++) {
                int mx = queue[front][0] + dx[i];
                int my = queue[front][1] + dy[i];
                if (0 <= mx && mx < n && 0 <= my && my < m) {
                    if (!visit[mx][my]) {
                        queue[rear][0] = mx;
                        queue[rear][1] = my;
                        queue[rear][2] = queue[front][2] + 1;
                        visit[mx][my] = true;
                        if (mx == n - 1 && my == m - 1) {
                            System.out.println(queue[rear][2]);
                            return;
                        }
                        rear++;
                    }
                }
            }
            front++;
        }
    }
}
