package SORT.Backjoon_15688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[2000001];

        int tmp;
        while (--n >= 0) {
            tmp = Integer.valueOf(br.readLine());
            arr[tmp + 1000000]++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2000001; i++) {
            while (arr[i]-- > 0) {
                sb.append(i-1000000);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
