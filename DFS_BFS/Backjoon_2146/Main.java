package DFS_BFS.Backjoon_2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] bridge, sea;
    static int n, minLength = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Deque<int[]> deque, findSea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        bridge = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                bridge[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Stack<int[]> startIndex = new Stack<>();
        int num = 2;    // 1은 방문했는 것만 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bridge[i][j] == 1) {
                    startIndex.add(new int[]{i, j});
                    bridge[i][j] = num++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(minLength);
    }

    private static void bfs(int i, int j) {
        deque = new LinkedList<>();
        deque.add(new int[]{i, j});      // 좌표, 다른 육지로 건너기 시작했는지 체크

        findSea = new LinkedList<>();
        sea = new int[n][n];
        while (!deque.isEmpty()) {
            int[] d = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = d[0] + dx[k];
                int my = d[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < n) {
                    if (bridge[mx][my] == 1) {
                        bridge[mx][my] = bridge[d[0]][d[1]];
                        deque.add(new int[]{mx, my});
                    }
                    if (bridge[mx][my] == 0) {
                        if (sea[mx][my] == 1) continue;
                        findSea.add(new int[]{mx, my});
                        sea[mx][my] = 1;
                    }
                }
            }
        }

        boolean notFound = true;
        while (!findSea.isEmpty() && notFound) {
            int[] d = findSea.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = d[0] + dx[k];
                int my = d[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < n) {
                    if (bridge[mx][my] == 0 && sea[mx][my] == 0) {
                        sea[mx][my] = sea[d[0]][d[1]] + 1;
                        findSea.add(new int[]{mx, my});
                    }
                    if (bridge[mx][my] == 1) {
                        if (minLength > sea[d[0]][d[1]]) {
                            minLength = sea[d[0]][d[1]];
                        }
                        notFound = false;
                    }
                }
            }

//            System.out.println("시작");
//            for (int a = 0; a < n; a++) {
//                for (int b = 0; b < n; b++) {
//                    System.out.print(sea[a][b] + " ");
//                }
//                System.out.println();
//            }
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
