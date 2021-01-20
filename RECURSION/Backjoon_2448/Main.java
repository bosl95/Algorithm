package RECURSION.Backjoon_2448;

import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] result;
    static int[] dx = {0, 1, 1, 2, 2, 2, 2, 2};
    static int[] dy = {2, 1, 3, 0, 1, 2, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        result = new char[n][2 * n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], ' ');
        }

        printStart(n, 0, 0);

        for (int i=0; i<n; i++) {
            bw.write(result[i]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    private static void printStart(int num, int a, int b) {
        if (num == 3) {
            for (int i = 0; i < 8; i++) {
                result[a + dx[i]][b + dy[i]] = '*';
            }
            return;
        }

        int m = num / 2;
        printStart(m, a, b + m);
        printStart(m, a + m, b);
        printStart(m, a + m, b + num);
    }
}
