package DFS_BFS.Backjoon_5427;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] building, fireStep;
    static int w, h;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Deque<int[]> fire = new LinkedList<>();
    static Deque<int[]> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            building = new int[h][w];
            fireStep = new int[h][w];

            for (int i = 0; i < h; i++) {
                String temp = br.readLine();
                for (int j = 0; j < w; j++) {
                    fireStep[i][j] = Integer.MAX_VALUE;
                    if (temp.charAt(j) == '@') {
                        stack.add(new int[]{i, j});
                    } else if (temp.charAt(j) == '#') {
                        building[i][j] = -1;
                    } else if (temp.charAt(j) == '*') {
                        building[i][j] = -1;
                        fire.add(new int[]{i, j});
                        fireStep[i][j] = 0;
                    }
                }
            }
            int[] start = stack.peekFirst();
            if (start[0] == 0 || start[0] == h - 1 || start[1] == 0 || start[1] == w - 1) {
                bw.write("1");
            } else {
                bw.write(escapeBuilding());
            }
            bw.write("\n");

            fire.clear();
            stack.clear();
        }
        bw.flush();
        bw.close();
    }

    public static String escapeBuilding() {
        while (!fire.isEmpty()) {
            int[] f = fire.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = f[0] + dx[k];
                int my = f[1] + dy[k];
                if (0 <= mx && mx < h && 0 <= my && my < w && building[mx][my] == 0 && fireStep[mx][my] > fireStep[f[0]][f[1]] + 1) {
                    fireStep[mx][my] = fireStep[f[0]][f[1]] + 1;
                    fire.add(new int[]{mx, my});
                }
            }
        }

        while (!stack.isEmpty()) {
            int[] s = stack.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = s[0] + dx[k];
                int my = s[1] + dy[k];
                if (0 <= mx && mx < h && 0 <= my && my < w && building[mx][my] == 0 && fireStep[mx][my] > building[s[0]][s[1]] + 1) {
                    building[mx][my] = building[s[0]][s[1]] + 1;
                    if (mx == 0 || mx == h - 1 || my == 0 || my == w - 1) {
                        return String.valueOf(building[mx][my] + 1);
                    }
                    stack.offer(new int[]{mx, my});
                }
            }
        }

        return "IMPOSSIBLE";
    }
}
