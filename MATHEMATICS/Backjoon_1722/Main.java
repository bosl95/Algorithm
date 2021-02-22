package MATHEMATICS.Backjoon_1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        factorial = new long[n + 1];
        boolean[] isUsed = new boolean[n + 1];
        getFactorial();

        st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        if (type == 1) {
            long k = Long.parseLong(st.nextToken()) - 1;
            for (int i=n; i>0; i--) {
                long mod = k / factorial[i - 1] + 1;
                k %= factorial[i - 1];
                long cnt = 0;
                int idx = 0;
                while (cnt != mod) {
                    idx ++;
                    if (!isUsed[idx]) cnt++;
                }
                isUsed[idx] = true;
                sb.append(idx + " ");
            }
        } else {
            long ans = 0;
            for (int i=0; i<n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                int idx = 0;
                while (num[i] != idx) {
                    idx++;
                    if(!isUsed[idx]) cnt++;
                }
                isUsed[idx] = true;
                ans += (cnt - 1) * factorial[n - i - 1];
            }
            sb.append(ans + 1);
        }
        System.out.println(sb);
    }

    private static void getFactorial() {
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
