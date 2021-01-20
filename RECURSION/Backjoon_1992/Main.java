package RECURSION.Backjoon_1992;

import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            board[i] = str.toCharArray();
        }

        quadTree(n, 0, 0);
        bw.flush();
        bw.close();
    }

    private static void quadTree(int num, int a, int b) throws IOException {
        if (num == 1) {
            bw.write(board[a][b]);
            return;
        }
        char x = board[a][b];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (x != board[a + i][b + j]) {
                    bw.write('(');
                    num /= 2;
                    quadTree(num, a, b);
                    quadTree(num, a, b + num);
                    quadTree(num, a + num, b);
                    quadTree(num, a + num, b + num);
                    bw.write(')');
                    return;
                }
            }
        }
        bw.write(x);
    }
}
