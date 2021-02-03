package BACK_TRACKING.Backjoon_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, count;
    static int[] array;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(-1 , 0);
        System.out.println(count);
    }

    private static void backtracking(int start, int result) {
        if (start != -1 && result == s) {
            count++;
        }

        for (int i=start + 1; i<n; i++) {
            visit[i] = true;
            backtracking(i, result + array[i]);
            visit[i] = false;
        }
    }
}
