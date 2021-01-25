package BACK_TRACKING.Backjoon_15654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static String[] result;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[n];
        result = new String[m * 2];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<2*m; i+=2) {
            result[i] = " ";
        }

        Arrays.sort(arr);
        backtracking(0);

        bw.flush();
        bw.close();
    }

    private static void backtracking(int num) throws IOException {
        if (num == m) {
            for (int i=0; i<2*m; i++) {
                bw.write(result[i]);
            }
            bw.write("\n");
            return;
        }

        for (int i=0; i<n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            result[num * 2] = String.valueOf(arr[i]);
            backtracking(num + 1);
            visit[i] = false;
        }
    }
}
