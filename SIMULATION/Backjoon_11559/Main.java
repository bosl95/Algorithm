package SIMULATION.Backjoon_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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

        while (!blocks.isEmpty()) {
            int[] xy = blocks.pop();
            if (board[xy[0]][xy[1]] != '.' && checkBlock(xy[0], xy[1])) {
                slide();
                printBlock();
                System.out.println("팡!");
            }
        }
    }

    private static void printBlock() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void slide() {
        for (int j = 0; j < 6; j++) {
            if (boomHeight[j] == -1) continue;
            int idx = boomHeight[j];
            for (int i = boomHeight[j]; i > 0; i--) {
                if (board[i][j] != blank) {
                    board[idx][j] = board[i][j];
                    board[i][j] = blank;
                    idx--;
                }
            }
        }
        Arrays.fill(boomHeight, -1);
    }

    private static boolean checkBlock(int x, int y) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{x, y});
        boolean findSame = false;
        char color = board[x][y];
        board[x][y] = blank;

        do {
            int[] xy = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int mx = xy[0] + dx[i];
                int my = xy[1] + dy[i];
                if (invalid(mx, my)) continue;

                if (board[mx][my] == color) {
                    findSame = true;
                    board[mx][my] = '.';
                    boomHeight[my] = Math.max(mx, boomHeight[my]);
                    deque.add(new int[]{mx, my});
                }
            }
        } while (!deque.isEmpty());

        return findSame;
    }

    private static boolean invalid(int mx, int my) {
        return 0 > mx || mx >= WIDTH || 0 > my || my >= HEIGHT;
    }
}
