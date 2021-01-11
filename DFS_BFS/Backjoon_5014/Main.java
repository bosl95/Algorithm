package DFS_BFS.Backjoon_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());   // floor
        s = Integer.parseInt(st.nextToken());   // start
        g = Integer.parseInt(st.nextToken());   // goal
        u = Integer.parseInt(st.nextToken());   // up
        d = -Integer.parseInt(st.nextToken());   // down
        if (s == g) {
            System.out.println(0);
            return;
        }

        dx = new int[]{u, d};
        System.out.println(bfs());
    }

    private static String bfs() {
        int[] visit = new int[f + 1];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(s);
        visit[s] = 1;

        while (!deque.isEmpty()) {
            int x = deque.pollFirst();
            for (int i = 0; i < 2; i++) {
                int mx = x + dx[i];
                if (0 < mx && mx < f + 1 && visit[mx] == 0) {
                    visit[mx] = visit[x] + 1;
                    if (mx == g) return String.valueOf(visit[mx] - 1);
                    deque.offer(mx);
                }
            }
        }

        return "use the stairs";
    }
}
