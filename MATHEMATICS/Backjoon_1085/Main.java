package MATHEMATICS.Backjoon_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[4];
        int i = 0;
        for (String x : br.readLine().split(" ")) {
            num[i++] = Integer.parseInt(x);
        }

        int w = Math.min(num[0], num[2] - num[0]);
        int h = Math.min(num[1], num[3] - num[1]);
        if (w > h) {
            System.out.println(h);
        } else {
            System.out.println(w);
        }
    }
}
