package DFS_BFS.Backjoon_10026;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static char[][] area;
    static char[][] blindArea;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        area = new char[n][n];
        blindArea = new char[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                area[i][j] = temp.charAt(j);
                blindArea[i][j] = temp.charAt(j) == 'G' ? 'R' : temp.charAt(j);
            }
        }

        int count = 0;
        int blindCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] != 'X') {
                    bfs(i, j, n, area);
                    count++;
                }
                if (blindArea[i][j] != 'X') {
                    bfs(i, j, n, blindArea);
                    blindCount++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.write(" ");
        bw.write(String.valueOf(blindCount));
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j, int n, char[][] area) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{i, j});
        char color = area[i][j];
        area[i][j] = 'X';

        while (!deque.isEmpty()) {
            int[] d = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = d[0] + dx[k];
                int my = d[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < n && area[mx][my] == color) {
                    area[mx][my] = 'X';
                    deque.offer(new int[]{mx, my});
                }
            }
        }
    }
}
