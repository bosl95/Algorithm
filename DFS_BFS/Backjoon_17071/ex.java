package DFS_BFS.Backjoon_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ex {
    static int n, k, time;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new int[500_001];
        time = 1;

        System.out.println(n == k ? 0 : bfs());
    }

    private static int bfs() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(n);
        visit[n] = 1;

        while (!deque.isEmpty()) {
            Deque<Integer> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                int x = deque.pollFirst();

                if (x - 1 >= 0 && visit[x - 1] < time) {
                    visit[x - 1] = time;
                    temp.offer(x - 1);
                }

                if (x + 1 <= 500_000 && visit[x + 1] < time) {
                    visit[x + 1] = time;
                    temp.offer(x + 1);
                }

                if (2 * x <= 500_000 && visit[2 * x] < time) {
                    visit[2 * x] = time;
                    temp.offer(2 * x);
                }

                if (visit[x] != time) visit[x] = 0;
            }

            deque = temp;

            k += time;
            if (k > 500_000) break;

            if (visit[k] != 0) {
                return time;
            }

            time++;
        }
        return -1;
    }
}