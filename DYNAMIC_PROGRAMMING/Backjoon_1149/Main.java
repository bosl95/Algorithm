package DYNAMIC_PROGRAMMING.Backjoon_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static final int COLS = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());

        int[][] rgb = new int[size][COLS];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COLS; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[size][COLS];
        dp[0] = Arrays.copyOf(rgb[0], COLS);

        if (size > 1) {
            for (int i = 1; i < size; i++) {
                dp[i][0] = Math.min(rgb[i][0] + dp[i - 1][1], rgb[i][0] + dp[i - 1][2]);
                dp[i][1] = Math.min(rgb[i][1] + dp[i - 1][0], rgb[i][1] + dp[i - 1][2]);
                dp[i][2] = Math.min(rgb[i][2] + dp[i - 1][0], rgb[i][2] + dp[i - 1][1]);
            }
        }
        System.out.println(Math.min(Math.min(dp[size - 1][0], dp[size - 1][1]), dp[size - 1][2]));
    }
}
