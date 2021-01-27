package BACK_TRACKING.Backjoon_6603;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static boolean[] visit;
    static int k, LOTTO_NUM = 6;
    static int[] S, result = new int[LOTTO_NUM];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            S = new int[k];
            visit = new boolean[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void lotto(int num) throws IOException {
        if (num == LOTTO_NUM) {
            for (int idx : result) {
                bw.write(String.valueOf(S[idx]));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        int start = (num == 0) ? 0 : result[num - 1];
        for (int i = start; i < k; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            result[num] = i;
            lotto(num + 1);
            visit[i] = false;
        }
    }
}
