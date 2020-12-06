package QUEUE_DEQUE.Backjoon_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class backjoon_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        String line;
        StringBuffer sb = new StringBuffer();

        while (num-- > 0) {
            line = br.readLine();

            if (line.startsWith("push_front")) {
                deque.addFirst(line.substring(11));
                continue;
            }

            if (line.startsWith("push_back")) {
                deque.add(line.substring(10));
                continue;
            }

            if (line.equals("size")) {
                sb.append(deque.size()+"\n");
                continue;
            }

            if (line.equals("empty")) {
                sb.append((deque.isEmpty()?1:0)+"\n");
                continue;
            }

            if (deque.isEmpty()) {
                sb.append(-1+"\n");
                continue;
            }

            switch (line) {
                case "pop_front" :
                    sb.append(deque.pollFirst()+"\n");
                    break;
                case "pop_back" :
                    sb.append(deque.pollLast()+"\n");
                    break;
                case "front" :
                    sb.append(deque.peekFirst()+"\n");
                    break;
                case "back" :
                    sb.append(deque.peekLast()+"\n");
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
