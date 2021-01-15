package DFS_BFS.Backjoon_11967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visit, light;
    static ArrayList<Integer>[] list;
    static Deque<Integer> deque;
    static int n, cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][n];
        light = new boolean[n][n];

        list = new ArrayList[n * n];
        for (int i = 0; i < n * n; i++) {
            list[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[x * n + y].add(a * n + b);
        }

        visit[0][0] = light[0][0] = true;
        deque = new LinkedList<>();
        deque.add(0);

        while (!deque.isEmpty()) {
            int d = deque.pollFirst();
            turnOn(d);

            int x = d / n;
            int y = d % n;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (isRange(mx, my) && light[mx][my] && !visit[mx][my]) {
                    visit[mx][my] = true;
                    deque.add(mx * n + my);
                }
            }
        }

        System.out.println(cnt);
    }

    private static void turnOn(int d) {
        for (int num : list[d]) {
            int x = num / n;
            int y = num % n;

            if (light[x][y]) continue;  // 이미 불이 켜져있다. (= 방문 했다.)
            light[x][y] = true;
            cnt++;  // 불을 키면 카운트

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (isRange(mx, my) && visit[mx][my]) { // 이미 방문한 적이 있다면
                    deque.add(mx * n + my); // 재방문 하도록
                }
            }
        }
    }

    private static boolean isRange(int mx, int my) {
        return (0 <= mx && mx < n && 0 <= my && my < n);
    }
}
