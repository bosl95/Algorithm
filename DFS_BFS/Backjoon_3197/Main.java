package DFS_BFS.Backjoon_3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visit;
    static char[][] ice;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Point[] swan = new Point[2];
    static Deque<Point> lake = new LinkedList<>(), search = new LinkedList<>();
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ice = new char[r][c];
        visit = new int[r][c];

        // '물공간과 접촉한 모든 빙판 공간은 녹는다.'
        String str;
        int count = 0;
        for (int i = 0; i < r; i++) {
            str = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = str.charAt(j);
                ice[i][j] = c;
                if (ice[i][j] == 'L') {
                    swan[count++] = new Point(i, j);
                }
                if (ice[i][j] != 'X') {
                    lake.offer(new Point(i, j));
                }
            }
        }

        System.out.println(melt());
    }

    private static int melt() {
        int time = 0;

        search.offer(swan[0]);
        visit[swan[0].x][swan[0].y] = 1;

        while (true) {
            Deque<Point> next = new LinkedList<>();
            while (!search.isEmpty()) {
                Point p = search.poll();
                if (p.x == swan[1].x && p.y == swan[1].y) {
                    return time;
                }
                for (int i = 0; i < 4; i++) {
                    int mx = p.x + dx[i];
                    int my = p.y + dy[i];
                    if (mx >= r || mx < 0 || my >= c || my < 0 || visit[mx][my] == 1) continue;
                    visit[mx][my] = 1;

                    if (ice[mx][my] == 'X') {
                        next.add(new Point(mx, my));
                        continue;
                    }
                    search.add(new Point(mx, my));
                }
            }

            search = next;
            int n = lake.size();

            while (n-- > 0) {
                Point p = lake.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = p.x + dx[i];
                    int my = p.y + dy[i];

                    if (mx >= r || mx < 0 || my >= c || my < 0) continue;

                    if (ice[mx][my] == 'X') {
                        ice[mx][my] = '.';
                        lake.offer(new Point(mx, my));
                    }
                }
            }

            time++;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
