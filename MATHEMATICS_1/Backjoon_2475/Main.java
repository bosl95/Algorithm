package MATHEMATICS_1.Backjoon_2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int result = 0;
        for (int i=0; i<9; i+=2) {
            result += Math.pow(chars[i] - '0', 2);
        }
        System.out.println(result % 10);
    }
}
