package STACK.Backjoon_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            sb.append(check(cmd, n, arr.substring(1, arr.length()-1).split(",")));
        }
        System.out.print(sb.toString());
    }

    private static String check(String cmd, int n, String[] arr) {
        int front = 0;
        int rear = n-1;
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(arr));

        for (int i=0; i<cmd.length(); i++) {
            if (cmd.charAt(i) == 'R') {
                int tmp = front;
                front = rear;
                rear = tmp;
            } else if (cmd.charAt(i) == 'D') {
                if (n==0 || list.isEmpty()) return "error\n";
                list.remove(front);
                if (front > rear) front--;
                else rear--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (front > rear) {
            Collections.reverse(list);
        }
        sb.append(String.join(",", list));
        sb.append("]");
        sb.append("\n");
        return sb.toString();
    }
}
