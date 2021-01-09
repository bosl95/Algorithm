package DFS_BFS.Backjoon_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 0, 1, 1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {0, 1, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2};
    static int k, h, w;
    static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        if (w == 1 && h == 1) {
            System.out.println(0);
            return;
        }

        area = new int[w][h];

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < h; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs());
    }

    private static int dfs() {
        Deque<Point> queue = new LinkedList<>(); // count가 더 큰 경우를 높은 우선순위를 가진다.
        queue.add(new Point(0, 0, 0, 0));
        int[][][] visit = new int[w][h][k + 1];

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.move + 1 <= k) {
                for (int i = 4; i < 12; i++) {
                    int mx = p.x + dx[i];
                    int my = p.y + dy[i];
                    if (0 <= mx && mx < w && 0 <= my && my < h && area[mx][my] == 0 && visit[mx][my][p.move + 1] == 0) {
                        if (mx == w - 1 && my == h - 1) return p.count + 1;
                        visit[mx][my][p.move + 1] = visit[p.x][p.y][p.move] + 1;
                        queue.add(new Point(mx, my, p.count + 1, p.move + 1));
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];
                if (0 <= mx && mx < w && 0 <= my && my < h && area[mx][my] == 0 && visit[mx][my][p.move] == 0) {
                    if (mx == w - 1 && my == h - 1) return p.count + 1;
                    visit[mx][my][p.move] = visit[p.x][p.y][p.move] + 1;
                    queue.add(new Point(mx, my, p.count + 1, p.move));
                }
            }
        }

        return -1;
    }

    static class Point{
        int x;
        int y;
        int count;
        int move;   // k번 사용할 수 있다.

        public Point(int x, int y, int count, int move) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.move = move;
        }
    }
}
