package ARRAY.Backjoon_11328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String[] a = st.nextToken().split("");
            String[] b = st.nextToken().split("");

            System.out.println(check(a, b));
        }
    }

    private static String check(String[] a, String[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i=0;i<a.length;i++) {
            if (!a[i].equals(b[i])) {
                return "Impossible";
            }
        }
        return "Possible";
    }
}
