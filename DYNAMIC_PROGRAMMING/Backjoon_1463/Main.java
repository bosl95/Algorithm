package DYNAMIC_PROGRAMMING.Backjoon_1463;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);

        while (!deque.isEmpty()) {
            int value = deque.pollFirst();
            if (value % 3 == 0 && dp[value / 3] > dp[value] + 1) {
                dp[value / 3] = dp[value] + 1;
                deque.add(value / 3);
            }

            if (value % 2 == 0 && dp[value / 2] > dp[value] + 1) {
                dp[value / 2] = dp[value] + 1;
                deque.add(value / 2);
            }

            if (value - 1 > 0 && dp[value - 1] > dp[value] + 1) {
                dp[value - 1] = dp[value] + 1;
                deque.add(value - 1);
            }
        }
        System.out.println(dp[1]);
    }
}
