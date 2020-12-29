package DFS_BFS.Backjoon_1012;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            int count = 0;
            visit = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1 && !visit[i][j]) {
                        dfs(m, n, i, j);
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int m, int n, int i, int j) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visit[i][j] = true;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            for (int k = 0; k < 4; k++) {
                int mx = pos[0] + dx[k];
                int my = pos[1] + dy[k];
                if (0 <= mx && mx < m && 0 <= my && my < n && arr[mx][my] == 1 && !visit[mx][my]) {
                    visit[mx][my] = true;
                    stack.push(new int[]{mx, my});
                }
            }
        }
    }
}
