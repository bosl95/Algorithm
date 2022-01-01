package MST.최소_스패닝_트리_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        int result = 0;
        for (int i = 0; i < e; i++) {
            Node node = pq.poll();
            int a = find(node.s);
            int b = find(node.e);
            if (a == b) continue;

            union(node.s, node.e);
            result += node.v;
        }

        System.out.println(result);
    }

    private static void union(int start, int end) {
        int aRoot = find(start);
        int bRoot = find(end);
        if (aRoot != bRoot) parent[aRoot] = end;
    }

    private static int find(int idx) {
        if (idx == parent[idx]) return idx;
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }
}

class Node implements Comparable<Node> {
    int s;
    int e;
    int v;

    public Node(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }


    @Override
    public int compareTo(Node o) {
        return o.v >= this.v ? -1 : 1;
    }
}
