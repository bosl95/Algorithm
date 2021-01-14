package BACK_TRACKING.Backjoon_15649;

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

        for (int i = 1; i < 2 * m; i += 2) {
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

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                path[2 * depth] = (char) (i + '0');
                backtracking(depth + 1);
                visit[i] = false;
            }
        }
    }
}
