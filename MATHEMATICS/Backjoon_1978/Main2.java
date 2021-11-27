package MATHEMATICS.Backjoon_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (String x : br.readLine().split(" ")) {
            if (isPrim(Integer.parseInt(x)))
                count ++;
        }
        System.out.println(count);
    }

    private static boolean isPrim(int value) {
        if (value == 1) return false;

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}
