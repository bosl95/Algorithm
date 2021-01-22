package MATHEMATICS.Backjoon_1929;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prim = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (prim[i]) continue;
            if (i >= m) sb.append(i).append('\n');
            for (int j = i + i; j <= n; j += i) {
                prim[j] = true;
            }
        }
        System.out.println(sb);
    }
}
