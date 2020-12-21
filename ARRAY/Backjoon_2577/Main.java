package ARRAY.Backjoon_2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] num = new int[10];
        int result = 1;

        for (int i=0; i<3; i++) {
            result = result * Integer.parseInt(br.readLine());
        }

        for (String s : String.valueOf(result).split("")) {
            num[Integer.parseInt(s)]++;
        }

        for (int n : num) {
            sb.append(n);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
