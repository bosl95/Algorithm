package ARRAY.Backjoon_13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] male = new int[6];
        int[] female = new int[6];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) {
                female[Integer.parseInt(st.nextToken())-1]++;
            } else {
                male[Integer.parseInt(st.nextToken())-1]++;
            }
        }

        int result = 0;
        for (int i=0; i<6; i++) {
            result += female[i]%k==0 ? female[i]/k : (female[i]/k)+1;
            result += male[i]%k==0 ? male[i]/k : (male[i]/k)+1;
        }
        System.out.print(result);
    }
}
