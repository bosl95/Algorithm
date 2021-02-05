package SIMULATION.Backjoon_14499;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] moveIndex = {{0, 3, 5, 4}, {0, 4, 5, 3}, {0, 1, 5, 2}, {0, 2, 5, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int index = Integer.parseInt(st.nextToken()) - 1;
            if (move(index)) {
                bw.write(String.valueOf(dice[0]));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean move(int dir) {
        int mx = x + dx[dir];
        int my = y + dy[dir];
        if (mx < 0 || mx >= n || my < 0 || my >= m) return false;
        x = mx;
        y = my;

        int[] index = moveIndex[dir];
        int temp = dice[index[0]];
        dice[index[0]] = dice[index[1]];
        dice[index[1]] = dice[index[2]];
        dice[index[2]] = dice[index[3]];
        dice[index[3]] = temp;

        if (map[x][y] == 0) {
            map[x][y] = dice[5];
        } else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
        return true;
    }
}
