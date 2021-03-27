package DYNAMIC_PROGRAMMING.Backjoon_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        int[] coins = new int[size];

        int[] dp = new int[value + 1];
        dp[0] = 1;  // 동전을 아예 사용하지 않는 경우는 1이다.
        for (int i = 0; i < size; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < size; i++) {
            for (int j = coins[i]; j <= value; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[value]);
    }
}
