package BACK_TRACKING.Backjoon_15663;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtracking(0, "");

        for (String s : set) {
            bw.write(s);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void backtracking(int num, String result) {
        if (num == m) {
            set.add(result);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            backtracking(num+1, result + arr[i] + " ");
            visit[i] = false;
        }
    }
}
