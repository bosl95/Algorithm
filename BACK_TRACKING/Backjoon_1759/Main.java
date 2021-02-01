package BACK_TRACKING.Backjoon_1759;

import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static String[] dict;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dict = new String[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            String str = st.nextToken();
            dict[i] = str;
        }

        Arrays.sort(dict);

        backTracking(0, "");

        bw.flush();
        bw.close();
    }

    private static void backTracking(int idx, String result) throws IOException {
        if (result.length() == l) {
            if (isPossible(result)) {
                bw.write(result);
                bw.write("\n");
            }
            return;
        }
        if (idx >= c) return;

        backTracking(idx + 1, result + dict[idx]);
        backTracking(idx + 1, result);
    }

    private static boolean isPossible(String ret) {
        int v = 0, c = 0;
        for (int i = 0; i < ret.length(); i++) {
            if (isVowel(ret.charAt(i))) v++;
            else c++;
        }
        return v >= 1 && c >= 2;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
