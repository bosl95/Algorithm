package QUEUE_DEQUE.Backjoon_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class backjoon_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String p, arr;
        boolean flag, error;   // 뒤집히면 false

        StringBuffer sb = new StringBuffer();
        while (--n>=0) {
            p = br.readLine();
            Integer.valueOf(br.readLine());
            arr = br.readLine();
            Deque<String> tmpArr = new LinkedList<>();
            for (String el : arr.substring(1, arr.length()-1).split(",")) {
                if (el.equals("")) break;
                tmpArr.add(el);
            }
            flag = true;
            error = false;

            for (String cmd : p.split("")) {
                if (cmd.equals("R")) {
                    flag = !flag;
                } else {
                    if (tmpArr.isEmpty()) {
                        error = true;
                        sb.append("error\n");
                        break;
                    } else if (flag) {
                        tmpArr.pollFirst();
                    } else {
                        tmpArr.pollLast();
                    }
                }
            }

            if (!error) {
                sb.append("[");
                if (flag) {
                    sb.append(String.join(",", tmpArr));
                } else  {
                    if (!tmpArr.isEmpty()) sb.append(tmpArr.pollLast());
                    while (!tmpArr.isEmpty()) {
                        sb.append(","+tmpArr.pollLast());
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
