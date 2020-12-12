package QUEUE_DEQUE.Backjoon_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backjoon_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int now = 0;
        int move = 0;
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i=0;i<N;i++) {
            queue.add(i+1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            int x = queue.indexOf(Integer.parseInt(st.nextToken()));
            int tmp = Math.abs(x-now);
            move += Math.min(tmp, queue.size()-tmp);
            queue.remove(x);
            now = x;
        }
        System.out.println(move);
    }
}
