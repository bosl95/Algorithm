package SORT.Backjoon_2108;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class backjoon_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum = 0.0;
        int intArray[] = new int[N];
        int mode[] = new int[8001];
        int max = 0;
        ArrayList<Integer> count = new ArrayList<>();

        for (int i=0; i<N; i++) {
            intArray[i] = Integer.parseInt(br.readLine());
            sum += intArray[i];
            mode[intArray[i]+4000]++;
        }

        System.out.println((int)Math.round(sum/N)); // 1. 산술 평균

        Arrays.sort(intArray);
        System.out.println(intArray[N/2]);  // 2. 중앙값

        for (int i=0; i<8001; i++){
            if (max <= mode[i]) {
                max = mode[i];
            }
        }

        for (int i=0; i<8001; i++) {
            if (mode[i] == max) {
                count.add(i-4000);
            }
        }


        if (count.size() == 1) {                // 3. 최빈값이 한개면
            System.out.println(count.get(0));   // 제일 앞에 있는 값을 출력
        } else {                                // 최빈값이 여러개면
            Collections.sort(count);            // 두번째 값 출력
            System.out.println(count.get(1));
        }

        System.out.println(intArray[N-1]-intArray[0]);  // 4. 입력값의 범위
    }

}
