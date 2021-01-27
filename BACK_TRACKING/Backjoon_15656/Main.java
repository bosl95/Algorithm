package BACK_TRACKING.Backjoon_15656;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, result;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0, "");

        bw.flush();
        bw.close();
    }

    private static void backtracking(int num, String result) throws IOException {
        if (num == m) {
            bw.write(result);
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            backtracking(num + 1, result + arr[i] + " ");
        }
    }
}
