package QUEUE_DEQUE.Backjoon_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class myQueue {
    int[] queue = new int[100000];
    int front = 0;
    int rear = 0;

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
        return front==rear;
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

public class backjoon_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        myQueue queue = new myQueue();
        StringBuffer sb = new StringBuffer();

        String command;
        while (n-->0) {
            command = br.readLine();

            if (command.startsWith("push")) {
                queue.push(Integer.parseInt(command.substring(5)));
                continue;
            }

            if (command.equals("pop")) {
                sb.append(queue.pop()+"\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()+"\n");
            } else if (command.equals("empty")) {
                sb.append((queue.empty()? 1:0)+"\n");
            } else if (command.equals("front")) {
                sb.append(queue.front()+"\n");
            } else if (command.equals("back")) {
                sb.append(queue.back()+"\n");
            }
        }

        System.out.println(sb.toString()+"\n");
    }
}
