package DYNAMIC_PROGRAMMING.Backjoon_1912;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] number = new int[size];
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = number[0];
        int result = number[0];
        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(dp[i - 1] + number[i], number[i]);
            if (result < dp[i]) result = dp[i];
        }
        System.out.println(result);
    }
}