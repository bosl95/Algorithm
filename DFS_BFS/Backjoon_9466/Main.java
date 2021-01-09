package DFS_BFS.Backjoon_9466;

import java.io.*;
import java.util.*;

public class Main {
    static int[] student;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            student = new int[n];
            visit = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                student[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            count = 0;
            for (int i = 0; i < n; i++) {
                dfs(i);
            }
            bw.write(String.valueOf(n - count) + '\n');
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int now) {
        if (visit[now]) return;

        visit[now] = true;
        int next = student[now];

        if (!visit[next]) {
            dfs(next);
        } else if (student[next] != -1) {
            count++;
            for (int i = next; i != now; i = student[i]) {
                count++;
            }
        }

        student[now] = -1;
    }
}
