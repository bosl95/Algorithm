package STACK.Backjoon_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        String command;

        while (num-- > 0) {
            command = br.readLine();

            if (command.startsWith("push")) {
                queue.add(command.split(" ")[1]);
                continue;
            }

            switch (command) {
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.pop());
                    break;
                case "size":
                    sb.append(queue.size());
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    sb.append(queue.isEmpty()? -1 : queue.peekFirst());
                    break;
                case "back":
                    sb.append(queue.isEmpty()? -1 : queue.peekLast());
                    break;
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
