package BACK_TRACKING.Backjoon_15663;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int n, m;
    static HashSet<Integer> arr;
    static Map<Integer, Boolean> visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new HashSet<>();
        visit = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (arr.contains(tmp)) continue;
            arr.add(tmp);
            visit.put(tmp, false);
        }

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
    }
}
