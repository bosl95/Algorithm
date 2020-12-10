package STACK.Backjoon_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class backjoon_10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        String input;
        StringBuffer sb = new StringBuffer();
        while (--n>=0) {
            input = br.readLine();

            if (input.startsWith("push")) {
                stack.add(Integer.valueOf(input.substring(5)));
                continue;
            }

            if (input.equals("pop")) {
                sb.append(stack.isEmpty()?-1: stack.pop());
            } else if (input.equals("size")) {
                sb.append(stack.size());
            } else if (input.equals("empty")) {
                sb.append(stack.isEmpty()?1:0);
            } else if (input.equals("top")) {
                sb.append(stack.isEmpty()?-1:stack.peek());
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}