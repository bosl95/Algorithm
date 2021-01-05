package DFS_BFS.Backjoon_7562;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] area;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            area = new int[l][l];
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x_ = Integer.parseInt(st.nextToken());
            int y_ = Integer.parseInt(st.nextToken());
            bw.write(bfs(x, y, x_, y_, l));
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    private static String bfs(int x, int y, int x_, int y_, int l) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{x, y});
        area[x][y] = 1;
        if (x == x_ && y == y_) return "0";

        while (!deque.isEmpty()) {
            int[] d = deque.pollFirst();
            for (int i = 0; i < 8; i++) {
                int mx = d[0] + dx[i];
                int my = d[1] + dy[i];
                if (0 <= mx && mx < l && 0 <= my && my < l && area[mx][my] == 0) {
                    area[mx][my] = area[d[0]][d[1]] + 1;
                    if (mx == x_ && my == y_) return String.valueOf(area[mx][my] - 1);
                    deque.add(new int[]{mx, my});
                }
            }
        }
        return "0";
    }
}
