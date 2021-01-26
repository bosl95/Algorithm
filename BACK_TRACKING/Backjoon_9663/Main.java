package BACK_TRACKING.Backjoon_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, count;
    static boolean[] cols, left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cols = new boolean[n];
        left = new boolean[2 * n - 1];    // 왼쪽 대각선
        right = new boolean[2 * n - 1];   // 오른쪽 대각선

        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int num) {
        if (num == n) {
            count++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (cols[j] || right[num + j] || left[n - 1 + num - j]) continue;
            cols[j] = right[num + j] = left[n - 1 + num - j] = true;
            backtracking(num + 1);
            cols[j] = right[num + j] = left[n - 1 + num - j] = false;
        }
    }
}
