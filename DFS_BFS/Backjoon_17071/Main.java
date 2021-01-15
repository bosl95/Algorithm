package DFS_BFS.Backjoon_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, k, time;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new int[2][500_001];

        time = 0;

        System.out.println(n == k ? 0 : bfs());
    }

    private static int bfs() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(n);
        visit[0][n] = 1;

        while (!deque.isEmpty()) {
            time++;
            int mod = time % 2;

            Deque<Integer> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                int x = deque.pollFirst();

                if (x - 1 >= 0 && visit[mod][x - 1] == 0) {
                    visit[mod][x - 1] = 1;
                    temp.offer(x - 1);
                }

                if (x + 1 <= 500_000 && visit[mod][x + 1] == 0) {
                    visit[mod][x + 1] = 1;
                    temp.offer(x + 1);
                }

                if (2 * x <= 500_000 && visit[mod][2 * x] == 0) {
                    visit[mod][2 * x] = 1;
                    temp.offer(2 * x);
                }
            }

            deque.addAll(temp);

            k += time;
            if (k > 500_000) break;
            if (visit[mod][k] != 0) return time;
        }
        return -1;
    }
}
