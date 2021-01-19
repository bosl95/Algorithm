package RECURSION.Backjoon_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }

    private static int func(int n, int a, int b) {
        int count = 0;

        while (true) {
            if (n == 1 || n / 2 == 1) {
                if (a == 0 && b == 0) {
                    return count;
                } else if (a == 0 && b == 1) {
                    return count + 1;
                } else if (a == 1 && b == 0) {
                    return count + 2;
                } else if (a == 1 && b == 1) {
                    return count + 3;
                }
            }

            n /= 2;

            if (a < n && n <= b) {          // 2사분면
                b -= n;
                count += (n * n);
            } else if (n <= a && b < n) {   // 3사분면
                a -= n;
                count += (n * n) * 2;
            } else if (n <= a && n <= b) {
                a -= n;
                b -= n;
                count += n * n * 3;
            }
        }
    }
}
