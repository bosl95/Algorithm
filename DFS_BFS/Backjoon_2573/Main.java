package DFS_BFS.Backjoon_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] ice;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m, amount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ice = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
                amount += ice[i][j];
            }
        }

        int time = -1;       // 작년 빙산개수를 세므로 -1부터 시작
        int count;      // 작년 빙산 개수
        while (true) {
            count = 0;
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ice[i][j] > 0 && !visit[i][j]) {    // bfs 탐색 및 얼음 녹이기
                        count++;
                        bfs(i, j);                          // 내년에 녹을 빙하
                    }
                }
            }

            time++;
            if ((amount == 0 && count == 1) || count == 0) {
                time = 0;
                break;
            } else if (count >= 2) break;
        }

        System.out.println(time);
    }

    private static void bfs(int i, int j) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{i, j});

        Stack<int[]> melt = new Stack<>();
        visit[i][j] = true;

        while (!deque.isEmpty()) {
            int[] d = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = d[0] + dx[k];
                int my = d[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < m) {
                    if (!visit[mx][my] && ice[mx][my] > 0) {
                        visit[mx][my] = true;
                        deque.add(new int[]{mx, my});
                    }
                    if (ice[mx][my] == 0) {
                        melt.push(d);
                    }
                }
            }
        }

        while (!melt.isEmpty()) {
            int[] m = melt.pop();
            if (ice[m[0]][m[1]] > 0) {
                ice[m[0]][m[1]]--;
                amount--;
            }
        }
    }
}
