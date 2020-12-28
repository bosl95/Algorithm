package STACK.Backjoon_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> stack = getValue(str);

        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek().charAt(0) == '(' || stack.peek().charAt(0) == '[') {
                result = 0;
                break;
            }
            result += Integer.parseInt(stack.pop());
        }
        System.out.println(result);
    }

    private static Stack<String> getValue(String str) {
        Stack<String> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case ')':
                    num = 0;
                    while (true) {
                        if (stack.isEmpty() || stack.peek().charAt(0) == '[') {
                            stack.clear();
                            stack.add("0");
                            return stack;
                        }
                        String ch = stack.pop();
                        if (ch.charAt(0) == '(') {
                            if (num == 0) stack.add("2");
                            else stack.add(String.valueOf(2 * num));
                            break;
                        } else {
                            num += Integer.parseInt(ch);
                        }
                    }
                    break;
                case ']':
                    num = 0;
                    while (true) {
                        if (stack.isEmpty() || stack.peek().charAt(0) == '(') {
                            stack.clear();
                            stack.add("0");
                            return stack;
                        }
                        String ch = stack.pop();
                        if (ch.charAt(0) == '[') {
                            if (num == 0) stack.add("3");
                            else stack.add(String.valueOf(3 * num));
                            break;
                        } else {
                            num += Integer.parseInt(ch);
                        }
                    }
                    break;
                default:
                    stack.add(String.valueOf(str.charAt(i)));
                    break;
            }
        }
        return stack;
    }
}
