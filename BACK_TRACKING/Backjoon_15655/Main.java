package BACK_TRACKING.Backjoon_15655;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, result;
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(0, -1);

        bw.flush();
        bw.close();
    }

    private static void backtracking(int num, int idx) throws IOException {
        if (num == m) {
            for (int i = 0; i < m; i++) {
                bw.write(String.valueOf(arr[result[i]]));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = idx + 1; i < n; i++) {
            result[num] = i;
            backtracking(num + 1, i);
        }
    }
}
