package MATHEMATICS.Backjoon_1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] count = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int page = 1; page <= n; page++) {
            countNumber(page);
        }
    }

    private static void countNumber(int page) {
        while (true) {
            int index = page % 10;
            count[index]++;
            page = (page - index) / 10;
            if (page <= 0) break;
        }
    }
}
