package RECURSION.Backjoon_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(multiple(b));
    }

    private static long multiple(long num) {
        if (num == 1) return (a % c);

        if (num % 2 == 0) {
            long x = multiple(num / 2) % c;
            return (x * x) % c;
        }
        return ((a % c) * multiple(num - 1) % c) % c;
    }
}
