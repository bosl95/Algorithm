package DFS_BFS.Backjoon_6593;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][][] building;
    static int[] start;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 0, 1, 0};
    static int[] dz = {0, 0, 0, -1, 0, 1};
    static int l, r, c;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l + r + c == 0) break;

            building = new int[l][r][c];
            String str;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        if (str.charAt(k) == 'S') {
                            building[i][j][k] = 1;          // 출발점
                            start = new int[]{i, j, k};
                        } else if (str.charAt(k) == 'E') {
                            building[i][j][k] = -1;         // 도착점
                        } else if (str.charAt(k) == '#') {
                            building[i][j][k] = -2;         // 벽
                        }
                    }
                }
                br.readLine();
            }

            bfs(start);
        }
        bw.flush();
        bw.close();
    }

    private static void bfs(int[] start) throws IOException {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(start);

        while (!deque.isEmpty()) {
            int[] d = deque.pollFirst();
            for (int i = 0; i < 6; i++) {
                int mx = d[0] + dx[i];
                int my = d[1] + dy[i];
                int mz = d[2] + dz[i];
                if (0 <= mx && mx < l && 0 <= my && my < r && 0 <= mz && mz < c) {
                    if (building[mx][my][mz] == 0 || (building[mx][my][mz] > 0 && building[mx][my][mz] > building[d[0]][d[1]][d[2]] + 1)) {
                        building[mx][my][mz] = building[d[0]][d[1]][d[2]] + 1;
                        deque.add(new int[]{mx, my, mz});
                    } else if (building[mx][my][mz] == -1) {
                        bw.write("Escaped in ");
                        bw.write(String.valueOf(building[d[0]][d[1]][d[2]]));
                        bw.write(" minute(s).\n");
                        return;
                    }
                }
            }
        }
        bw.write("Trapped!\n");
    }
}
