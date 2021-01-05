package DFS_BFS.Backjoon_2583;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] area;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        area = new boolean[n][m];

        int k = Integer.parseInt(st.nextToken());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x_ = Integer.parseInt(st.nextToken());
            int y_ = Integer.parseInt(st.nextToken());
            for (int i = x; i < x_; i++) {
                for (int j = y; j < y_; j++) {
                    area[i][j] = true;
                }
            }
        }

        int count = 0;
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!area[i][j]) {
                    count++;
                    list.add(bfs(i, j, n, m));
                }
            }
        }

        Collections.sort(list);

        bw.write(String.valueOf(count)+'\n');
        list.forEach(e -> {
            try {
                bw.write(String.valueOf(e)+" ");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }

    private static int bfs(int i, int j, int n, int m) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{i, j});
        int count = 1;
        area[i][j] = true;

        while (!deque.isEmpty()) {
            int[] d = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int mx = d[0] + dx[k];
                int my = d[1] + dy[k];
                if (0 <= mx && mx < n && 0 <= my && my < m && !area[mx][my]) {
                    deque.offer(new int[]{mx, my});
                    area[mx][my] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
