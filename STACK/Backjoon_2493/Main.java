package STACK.Backjoon_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n];
        int[] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && tower[stack.peek()] <= tower[i]) {
                result[stack.pop()] = i + 1;
            }
            stack.push(i);
        }

        for (int i=0; i<n; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        System.out.print(sb.toString());
    }
}
