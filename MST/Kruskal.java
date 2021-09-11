package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Kruskal {

    static int N;
    static int E;
    static int[] parent;
    static boolean[] visit;
    static int result;
    static PriorityQueue<A> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visit = new boolean[N + 1];

        pq = new PriorityQueue<>();
        String[] tempStr;
        for (int i = 0; i < E; i++) {
            tempStr = br.readLine().split(" ");
            pq.add(new A(
                    Integer.parseInt(tempStr[0]),
                    Integer.parseInt(tempStr[1]),
                    Integer.parseInt(tempStr[2])
            ));
        }

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            A node = pq.poll();
            int start = node.s;
            int end = node.e;
            int a = find(start);
            int b = find(end);
            if (a == b) continue;

            union(start, end);
            result += node.v;
        }
        System.out.println(result);
    }

    private static void union(int start, int end) {
        int aRoot = find(start);
        int bRoot = find(end);
        if (aRoot != bRoot) {
            parent[aRoot] = end;
        }
    }

    private static int find(int idx) {
        if (idx == parent[idx]) return idx;
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    private static class A implements Comparable<A> {
        int s;
        int e;
        int v;

        public A(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(A o) {
            return o.v >= this.v ? -1 : 1;
        }
    }
}

/*
7
11
1 2 2
2 7 7
7 6 9
6 5 23
5 4 1
4 1 10
1 3 3
2 3 3
3 7 4
3 6 3
3 5 6
 */
