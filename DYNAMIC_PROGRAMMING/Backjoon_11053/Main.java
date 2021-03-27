package DYNAMIC_PROGRAMMING.Backjoon_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        int[] number = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] length = new int[size];
        length[0] = 1;

        int maxLength = 1;  // 한 개일 경우에 주의해야한다!
        for (int i = 1; i < size; i++) {
            int tempLength = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (number[j] < number[i] && tempLength < length[j] + 1) {
                    tempLength = length[j] + 1;
                }
            }
            length[i] = tempLength;
            maxLength = Math.max(tempLength, maxLength);
        }
        System.out.println(maxLength);
    }
}
