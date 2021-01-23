package MATHEMATICS.Backjoon_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long gcd, lcm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());
        if (num1 > num2) {
            long tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        GCD(num1, num2);
        LCM(num1, num2);
        sb.append(gcd).append("\n").append(lcm);
        System.out.println(sb);
    }

    private static void LCM(long num1, long num2) {
        lcm = (num1 * num2) / gcd;
    }

    private static void GCD(long num1, long num2) {
        while (num2 > 0) {
            long tmp = num1;
            num1 = num2;
            num2 = tmp % num2;
        }
        gcd = num1;
    }
}
