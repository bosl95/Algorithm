package MST.우주신과의_교감_1774;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static Position[] positions;
    static double[][] distance;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        distance = new double[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        positions = new Position[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Position(i, x, y);
        }

        // 간선
        int count = 0;
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = find(a);
            b = find(b);
            if (a != b) { // 만약 최상위 부모 노드가 같지 않다면
                union(a, b);
                count += 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                Position p1 = positions[i];
                Position p2 = positions[j];
                double diff = Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
                distance[i][j] = diff;
                distance[j][i] = diff;
                pq.add(new Node(p1, p2, diff));
            }
        }

        double ans = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = find(node.p1.idx);
            int v = find(node.p2.idx);
            if (u != v) {
                union(u, v);
                ans += node.v;
                count += 1;
            }
            if (count == n - 1) break;
        }

        System.out.println(String.format("%.2f", ans));
    }

    private static void union(int start, int end) {
        int aRoot = find(start);
        int bRoot = find(end);
        if (aRoot != bRoot) {
            parent[aRoot] = end;
        }
    }

    private static int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}

class Position {
    int idx;
    int x;
    int y;

    public Position(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}

class Node implements Comparable<Node> {
    Position p1;
    Position p2;
    double v;

    public Node(Position p1, Position p2, double v) {
        this.p1 = p1;
        this.p2 = p2;
        this.v = v;
    }

    @Override
    public int compareTo(Node o) {
        return o.v >= this.v ? -1 : 1;
    }
}
