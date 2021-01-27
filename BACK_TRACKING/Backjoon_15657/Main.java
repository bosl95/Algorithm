package BACK_TRACKING.Backjoon_15657;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, result;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(0);
        bw.flush();
        bw.close();
    }

    private static void backtracking(int num) throws IOException {
        if (num == m) {
            for (int idx : result) {
                bw.write(String.valueOf(arr[idx]));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        int start = (num == 0) ? 0 : result[num - 1];
        for (int i = start; i < n; i++) {
            result[num] = i;
            backtracking(num + 1);
        }
    }
}
