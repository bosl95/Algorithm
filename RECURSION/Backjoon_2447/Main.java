package RECURSION.Backjoon_2447;

import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        result = new char[n][n];

        for (int i=0; i<n; i++) {
            Arrays.fill(result[i], ' ');
        }

        func(n, 0, 0);

        for (int i=0; i<n; i++) {
            bw.write(result[i]);
            bw.write('\n');
        }
        bw.close();
    }

    private static void func(int n, int a, int b) {
        if (n == 1) {
            result[a][b] = '*';
            return;
        }

        n /= 3;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == 1 && j == 1) continue;
                func(n, a + (n * i), b + (n * j));
            }
        }
    }
}
