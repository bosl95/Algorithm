package SORT.Backjoon_10989;

import java.io.*;

public class backjoon_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[10001];

        for (int i=0; i<n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            array[tmp] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<10001; i++) {
            while (array[i]>0) {
                sb.append(i);
                sb.append("\n");
                array[i] -= 1;
            }
        }

        System.out.print(sb);
    }
}
