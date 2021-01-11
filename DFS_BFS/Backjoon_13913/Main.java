package DFS_BFS.Backjoon_13913;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            bw.write("0\n");
            bw.write(String.valueOf(n));
            bw.flush();
            bw.close();
            return;
        }
        int[] visit = new int[200001];
        for (int i = 0; i < 200001; i++) {
            visit[i] = -1;
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.add(n);

        visit[n] = 0;
        while (!deque.isEmpty()) {
            int x = deque.pollFirst();
            if (x == k) break;

            if (2 * x < 100001 && visit[2 * x] == -1) {
                visit[2 * x] = x;
                deque.add(2 * x);
            }
            if (x < 100000 && visit[x + 1] == -1) {
                visit[x + 1] = x;
                deque.add(x + 1);
            }
            if (0 < x && visit[x - 1] == -1) {
                visit[x - 1] = x;
                deque.add(x - 1);
            }
        }

        deque.clear();
        for (int i = k; i != n; i = visit[i]) {
            deque.add(i);
        }
        deque.add(n);

        int size = deque.size();
        bw.write(String.valueOf(size - 1));
        bw.write("\n");

        while (!deque.isEmpty()) {
            bw.write(String.valueOf(deque.pollLast()));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
    }
}
