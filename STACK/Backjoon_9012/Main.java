package STACK.Backjoon_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        while (num-- > 0) {
            sb.append(VPS(br.readLine()));
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static String VPS(String str) {
        Stack<String> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add("(");
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }
}
