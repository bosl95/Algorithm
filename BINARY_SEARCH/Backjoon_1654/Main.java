package BINARY_SEARCH.Backjoon_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] lan = new int[n];

        for (int i = 0; i < n; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        long max = lan[n - 1];
        long min = 1;
        long mid;

        while (max >= min) {
            mid = (max + min) / 2;

            long count = 0;

            for (int i=0; i<n; i++) {
                count += lan[i] / mid;
            }

            if (count >= k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }
}
