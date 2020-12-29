package DFS_BFS.Backjoon_1926;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        int count = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '1' && visit[i][j] == 0) {
                    area = Math.max(area, BFS(n, m, i, j));
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.write("\n");
        bw.write(String.valueOf(area));
        bw.flush();
        bw.close();
    }

    private static int BFS(int n, int m, int i, int j) {
        int area = 1;
        Stack<int[]> queue = new Stack<>();
        queue.add(new int[]{i, j});
        visit[i][j] = 1;

        while (!queue.isEmpty()) {
            int[] dot = queue.pop();
            for (int k = 0; k < 4; k++) {
                int mx = dot[0] + dx[k];
                int my = dot[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < m && arr[mx][my] == '1' && visit[mx][my] == 0) {
                    queue.add(new int[]{mx, my});
                    visit[mx][my] = 1;
                    area++;
                }
            }
        }
        return area;
    }
}
