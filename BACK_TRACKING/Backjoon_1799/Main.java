package BACK_TRACKING.Backjoon_1799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] size, cnt;
    static boolean[] left, right;
    static List<int[]> odd, even;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        odd = new ArrayList<>();
        even = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().charAt(0) == '1') {
                    if (i + j % 2 == 0) even.add(new int[]{i, j});
                    else odd.add(new int[]{i, j});
                }
            }
        }
        size = new int[2];
        cnt = new int[2];
        size[0] = odd.size();
        size[1] = even.size();

        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];

        for (int i = 0; i < size[0]; i++) {
            backtracking(0, i, 0);
        }
        for (int i=0; i < size[1]; i++) {
            backtracking(0, i, 1);
        }

        System.out.println(cnt[0] + cnt[1]);
    }

    private static void backtracking(int num, int idx, int i) {
        if (idx == size[i]) return;
        if (num > cnt[i]) cnt[i] = num;

        int[] xy = (i == 0) ? odd.get(idx) : even.get(idx);
        if (possible(xy[0], xy[1])) {
            boolean l = left[xy[0] + xy[1]];
            boolean r = right[n + xy[0] - xy[1] - 1];  // backup

            left[xy[0] + xy[1]] = right[n + xy[0] - xy[1] - 1] = true;
            backtracking(num + 1, idx + 1, i);
            left[xy[0] + xy[1]] = l;
            right[n + xy[0] - xy[1] - 1] = r;
        }
        backtracking(num, idx + 1, i);
    }

    private static boolean possible(int i, int j) {
        return !left[i + j] && !right[n + i - j - 1];
    }
}
