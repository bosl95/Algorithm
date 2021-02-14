package SIMULATION.Backjoon_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] space = new char[5][5];
    static boolean[] visit = new boolean[1 << 25];
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    static int result;
    static int n = 5, N = 25;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            space[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[1 << (i * n + j)] = true;
                dfs(1, (space[i][j] == 'S' ? 1 : 0), (1 << i * n + j));
            }
        }
        System.out.println(result);
    }

    private static void dfs(int cnt, int s, int check) {
        if (cnt == 7) {
            if (s > 3) result++;
            return;
        }

        for (int i=0; i<N; i++) {
            if ((check & (1 << i)) == 0) continue;

            int x = i / n;
            int y = i % n;

            for (int k=0; k<4; k++) {
                int mx = x + dx[k];
                int my = y + dy[k];
                if (isInvalid(mx, my)) continue;
                int num = mx * n + my;

                if (visit[check | (1 << num)]) continue;
                visit[check | (1 << num)] = true;

                dfs(cnt + 1, (space[mx][my] == 'S'? s + 1 : s), (check | (1 << num)));
            }
        }
    }

    private static boolean isInvalid(int mx, int my) {
        return 0 > mx || mx >= n || 0 > my || my >= n;
    }
}
