package SORT.Backjoon_11931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[2000001];

        int tmpInt;
        while (--n>=0) {
            tmpInt = Integer.valueOf(br.readLine());
            arr[tmpInt+1000000]++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i=1000000;i>=-1000000;i--) {
            if (arr[i+1000000]!=0) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
