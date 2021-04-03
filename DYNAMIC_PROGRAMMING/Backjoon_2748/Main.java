package DYNAMIC_PROGRAMMING.Backjoon_2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        long[] dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[number]);
    }
}
