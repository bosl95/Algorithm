package SIMULATION.Backjoon_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] board;
    static int boom, WIDTH = 12, HEIGHT = 6;
    static int[] boomHeight;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static char blank = '.';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[WIDTH][HEIGHT];
        boomHeight = new int[HEIGHT];   // 터진 블럭 위치 중 최소에 위치한 값
        Arrays.fill(boomHeight, -1);

        Stack<int[]> blocks = new Stack<>();
        String str;
        for (int i = 0; i < WIDTH; i++) {
            str = br.readLine();
            for (int j = 0; j < HEIGHT; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] != '.') blocks.add(new int[]{i, j});
            }
        }

        boolean isBoom;
        while (true) {
            isBoom = false;
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    if (board[i][j] != blank) {
                        if (checkBlock(i, j)) {
                            isBoom = true;
                        }
                    }
                }
            }

            if (!isBoom) break;
            slide();
            boom++;
        }
        System.out.println(boom);
    }

    private static void slide() {
        for (int i = 0; i < HEIGHT; i++) {
            if (boomHeight[i] != -1) {
                int idx = boomHeight[i];
                for (int j = boomHeight[i]; j > -1; j--) {
                    if (board[j][i] != blank) {
                        board[idx--][i] = board[j][i];
                        board[j][i] = blank;
                    }
                }
            }
        }
        Arrays.fill(boomHeight, -1);
    }

    private static boolean checkBlock(int x, int y) {
        char color = board[x][y];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{x, y});

        boolean[][] visit = new boolean[WIDTH][HEIGHT];
        visit[x][y] = true;
        int count = 1;

        Stack<int[]> deleteStack = new Stack<>();
        while (!deque.isEmpty()) {
            int[] xy = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int mx = xy[0] + dx[i];
                int my = xy[1] + dy[i];
                if (checkIndex(mx, my)) continue;

                if (board[mx][my] == color && !visit[mx][my]) {
                    int[] position = new int[]{mx, my};
                    deque.add(position);
                    count++;
                    deleteStack.add(position);
                    visit[mx][my] = true;
                }
            }
        }

        if (count >= 4) {
            deleteStack.add(new int[]{x, y});
            while (!deleteStack.isEmpty()) {
                int[] xy = deleteStack.pop();
                board[xy[0]][xy[1]] = blank;
                boomHeight[xy[1]] = (boomHeight[xy[1]] == -1) ? xy[0] : Math.max(boomHeight[xy[1]], xy[0]);
            }
            return true;
        }
        return false;
    }

    private static boolean checkIndex(int mx, int my) {
        return 0 > mx || mx >= WIDTH || 0 > my || my >= HEIGHT;
    }
}
