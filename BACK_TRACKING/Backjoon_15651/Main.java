package BACK_TRACKING.Backjoon_15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[] path;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        path = new char[2 * m];

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
            bw.write('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            path[2 * depth] = (char) (i + '0');
            backtracking(depth + 1);
        }
    }
}
