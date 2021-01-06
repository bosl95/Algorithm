package DFS_BFS.Backjoon_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] visit;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int i, int j) {
        Deque<Point> deque = new LinkedList<>();
        deque.offer(new Point(i, j, 1, 0));

        while (!deque.isEmpty()) {
            Point point = deque.poll();

            if (point.x == n - 1 && point.y == m - 1) return point.distance;

            for (int k = 0; k < 4; k++) {
                int mx = point.x + dx[k];
                int my = point.y + dy[k];

                if (0 <= mx && mx < n && 0 <= my && my < m) {
                    if (visit[mx][my] > point.drill) { // 다음 노드가 방문 x 혹은 벽을 부순적이 없는 경우(방문 했을 수 있음)
                        if (map[mx][my] == 0) {  // 벽이 아닌 경우
                            deque.add(new Point(mx, my, point.distance + 1, point.drill));
                            visit[mx][my] = point.drill;
                        } else {    // 벽을 만난 경우
                            if (point.drill == 0) {
                                deque.add(new Point(mx, my, point.distance + 1, point.drill + 1));
                                visit[mx][my] = point.drill + 1;
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Point {
        int x;
        int y;
        int distance;
        int drill;

        public Point(int x, int y, int distance, int drill) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.drill = drill;
        }
    }
}
