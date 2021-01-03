package DFS_BFS.Backjoon_2667;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        square = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                square[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == 1) {
                    list.add(DFS(i, j, n));
                    count++;
                }
            }
        }
        sb.append(count).append("\n");

        Collections.sort(list);
        list.forEach(e -> sb.append(e).append("\n"));

        System.out.print(sb.toString());
    }

    private static int DFS(int i, int j, int n) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{i, j});
        square[i][j] = 0;

        int cnt = 1;
        while (!deque.isEmpty()) {
            int[] el = deque.poll();
            for (int k = 0; k < 4; k++) {
                int mx = el[0] + dx[k];
                int my = el[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < n && square[mx][my] == 1) {
                    square[mx][my] = 0;
                    deque.add(new int[]{mx, my});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
