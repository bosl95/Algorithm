package DFS_BFS.Backjoon_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }
        int[] visit = new int[100001];
        for (int i = 0; i < 100001; i++) {
            visit[i] = Integer.MAX_VALUE;
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.add(n);

        visit[n] = 0;
        while (!deque.isEmpty()) {
            int x = deque.pollFirst();
            if (x == k) break;

            if (2 * x < 100001 && visit[2 * x] > visit[x]) {
                visit[2 * x] = visit[x];
                deque.add(2 * x);
            }
            if (x < 100000 && visit[x + 1] > visit[x] + 1) {
                visit[x + 1] = visit[x] + 1;
                deque.add(x + 1);
            }
            if (0 < x && visit[x - 1] > visit[x] + 1) {
                visit[x - 1] = visit[x] + 1;
                deque.add(x - 1);
            }
        }
        System.out.println(visit[k]);
    }
}
