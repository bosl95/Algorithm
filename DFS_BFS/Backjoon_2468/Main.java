package DFS_BFS.Backjoon_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static int[][] area;
    static int n;
    static int result = 1;  // 비가 오지 않으면 답은 1이 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        area = new int[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] < min) min = area[i][j];
                if (area[j][j] > max) max = area[i][j];
            }
        }

        for (int i = min; i <= max; i++) {
            int safe = safeArea(i);
            if (safe > result) result = safe;
        }
        System.out.println(result);
    }

    private static int safeArea(int limit) {
        visit = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] > limit && !visit[i][j]) {
                    visit[i][j] = true;
                    count++;
                    bfs(i, j, limit);
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j, int limit) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{i, j});

        while (!deque.isEmpty()) {
            int[] el = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = el[0] + dx[k];
                int my = el[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < n && area[mx][my] > limit && !visit[mx][my]) {
                    visit[mx][my] = true;
                    deque.add(new int[]{mx, my});
                }
            }
        }
    }
}
