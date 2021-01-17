package BACK_TRACKING.Backjoon_15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visit;
    static char[] path;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        path = new char[m * 2];

        for (int i = 1; i < m * 2; i += 2) {
            path[i] = ' ';
        }

        backtracking(0);

        bw.flush();
        bw.close();
    }

    private static void backtracking(int depth) throws IOException {
        if (depth == m) {
            bw.write(path);
            bw.write("\n");
            return;
        }

        int start = (depth == 0) ? 1 : path[(depth - 1) * 2] - '0';
        for (int i = start; i <= n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            path[depth * 2] = (char) (i + '0');
            backtracking(depth + 1);
            visit[i] = false;
        }
    }
}
