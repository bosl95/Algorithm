package STACK.backjoon_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.add(i);
            sb.append("+");
            sb.append("\n");
            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                sb.append("-");
                sb.append("\n");
                index++;
            }
        }
        if (index == n) {
            System.out.print(sb.toString());
        } else {
            System.out.print("NO");
        }
    }
}