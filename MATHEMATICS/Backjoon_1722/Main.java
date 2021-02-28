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
        if (type == 1) {        // k 번째 순열이 무엇인지 찾기
            long k = Long.parseLong(st.nextToken()) - 1;
            for (int i = n; i > 0; i--) {
                long mod = k / factorial[i - 1] + 1;    // idx가 0부터 시작하므로 +1
                k %= factorial[i - 1];
                long cnt = 0;
                int idx = 0;
                while (cnt != mod) {
                    idx++;              // 숫자(idx)를 하나씩 증가
                    if (!isUsed[idx]) { // 숫자(idx)가 아직 사용되지 않았다면
                        cnt++;
                    }
                }
                isUsed[idx] = true;
                sb.append(idx + " ");
            }
        } else {                // 몇번째 순열인지 찾기
            long ans = 0;
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                int idx = 0;
                while (num[i] != idx) {
                    idx++;
                    if (!isUsed[idx]) cnt++;
                }
                isUsed[idx] = true;
                ans += (cnt - 1) * factorial[n - i - 1];    // num[i] != idx가 뒤에 검사 되므로 cnt - 1이어야함
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
        // factorial[2] = 1 * 2 = 2, factorial[3] = 2 * 3 = 6 ...
    }
}
