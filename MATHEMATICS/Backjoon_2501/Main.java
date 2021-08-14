package MATHEMATICS.Backjoon_2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(findResult(n, k));
    }

    private static int findResult(int n, int k) {
        int count = 0;
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                count += 1;
                if (count == k) return i;
            }
        }
        return result;
    }
}
