package DYNAMIC_PROGRAMMING.Bakcjoon_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] stair = new int[size];
        for (int i = 0; i < stair.length; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (size < 3) {
            System.out.println(Arrays.stream(stair).sum());
        } else {
            int[] dp = new int[size];
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
            dp[2] = Math.max(stair[1] + stair[2], stair[0] + stair[2]);

            for (int i = 3; i < size; i++) {
                dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
            }
            System.out.println(dp[size - 1]);
        }
    }
}
