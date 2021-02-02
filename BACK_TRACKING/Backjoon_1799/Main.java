package BACK_TRACKING.Backjoon_1799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] color, visit;
    static int[] result = new int[2];
    static int[] dx = {-1, -1};
    static int[] dy = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        color = new boolean[n][n];
        visit = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                color[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
            }
        }

        backtracking(-1, true, 0);
        backtracking(-1, false, 0);

        System.out.println(result[0] + result[1]);
    }

    private static void backtracking(int idx, boolean black, int count) {
        for (int i = idx + 1; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            if (color[x][y] != black || board[x][y] == 0 || !possible(x, y)) continue;

            visit[x][y] = true;
            backtracking(i, black, count + 1);
            visit[x][y] = false;
        }

        result[black ? 1 : 0] = Math.max(result[black ? 1 : 0], count);
    }
    private static boolean possible(int x, int y) {
        for (int i = 0; i < 2; i++) {
            int mx = x;
            int my = y;
            while (true) {
                if (mx < 0 || mx >= n || my < 0 || my >= n) break;
                if (visit[mx][my]) return false;
                mx += dx[i];
                my += dy[i];
            }
        }
        return true;
    }
}
