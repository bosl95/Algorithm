package SORT.Backjoon_2750;

import java.util.Arrays;
import java.util.Scanner;

public class backjoon_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int NumArrays[] = new int[num];

        for (int i=0; i<num; i++){
            NumArrays[i] = sc.nextInt();
        }
        Arrays.sort(NumArrays);

        for (int i=0; i<num; i++){
            System.out.println(NumArrays[i]);
        }
    }
}
