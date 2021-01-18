package RECURSION.Backjoon_11729;

import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, k)-1);
        hanoi(k, 1, 2, 3);
        bw.close();
    }

    private static void hanoi(int k, int from, int mid, int to) throws IOException {
        if (k == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        hanoi(k-1, from, to, mid);
        bw.write(from + " " + to + "\n");
        hanoi(k-1, mid, from, to);
    }
}
