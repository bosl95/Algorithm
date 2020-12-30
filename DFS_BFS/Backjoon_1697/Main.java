package DFS_BFS.Backjoon_1697;

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
        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        int[] pos = new int[100001];
        Deque<Integer> stack = new LinkedList<>();
        stack.add(n);

        while (!stack.isEmpty()) {
            if (pos[k] != 0) break;

            int x = stack.pollFirst();

            if (x + 1 <= 100000 && pos[x + 1] == 0) {
                pos[x + 1] = pos[x] + 1;
                stack.add(x + 1);
            }

            if (x - 1 >= 0 && pos[x - 1] == 0) {
                pos[x - 1] = pos[x] + 1;
                stack.add(x - 1);
            }

            if (2 * x <= 100000 && pos[2 * x] == 0) {
                pos[2 * x] = pos[x] + 1;
                stack.add(2 * x);
            }
        }
        System.out.println(pos[k]);
    }
}
