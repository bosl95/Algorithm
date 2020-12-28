package STACK.Backjooon_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char pre = str.charAt(0);

        int bar = 0;
        int result = 0;
        for (int i = 1; i < str.length(); i++) {
            if (pre == '(' && str.charAt(i) == '(') {
                bar++;
            } else if (pre == '(' && str.charAt(i) == ')') {
                result += bar;
            } else if (pre == ')' && str.charAt(i) == ')') {
                result++;
                bar--;
            }
            pre = str.charAt(i);
        }
        System.out.println(result);
    }
}
