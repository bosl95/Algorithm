package SIMULATION.Backjoon_1547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            mix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(ans);
    }

    private static void mix(int idx1, int idx2) {
        if (idx1 == ans) {
            ans = idx2;
        } else if (idx2 == ans) {
            ans = idx1;
        }
    }
}
