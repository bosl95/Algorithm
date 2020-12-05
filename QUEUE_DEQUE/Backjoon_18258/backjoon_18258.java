package QUEUE_DEQUE.Backjoon_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class myQueue {
    int[] queue = new int[2000000];
    private int front = 0;
    private int rear = 0;

    public void push(int x) {
        queue[rear++] = x;
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        return queue[front++];
    }

    public int size() {
        return rear-front;
    }

    public boolean empty() {
        return front == rear;
    }

    public int front() {
        if (empty()) {
            return -1;
        }
        return queue[front];
    }

    public int back() {
        if (empty()) {
            return -1;
        }
        return queue[rear-1];
    }
}

public class backjoon_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        myQueue queue = new myQueue();
        StringBuffer sb = new StringBuffer();

        int n = Integer.valueOf(br.readLine());

        String cmd;
        for (int i=0; i<n; i++) {
            cmd = br.readLine();

            if (cmd.startsWith("push")) {
                queue.push(Integer.valueOf(cmd.substring(5)));
                continue;
            }

            if (cmd.equals("pop")) {
                sb.append(queue.pop()+"\n");
            } else if (cmd.equals("size")) {
                sb.append(queue.size()+"\n");
            } else if (cmd.equals("empty")) {
                sb.append((queue.empty()? 1:0) +"\n");
            } else if (cmd.equals("front")) {
                sb.append(queue.front()+"\n");
            } else if (cmd.equals("back")) {
                sb.append(queue.back()+"\n");
            }
        }

        System.out.println(sb.toString()+"\n");
    }
}
