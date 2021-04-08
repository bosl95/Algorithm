package DYNAMIC_PROGRAMMING.Backjoon_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] wine = new int[number + 1];
        int[] maxDrink = new int[number + 1];
        for (int i = 1; i < number + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        maxDrink[1] = wine[1];
        if (number > 1) {
            maxDrink[2] = wine[1] + wine[2];
        }

        for (int i = 3; i < number + 1; i++) {
            maxDrink[i] = Math.max(Math.max(maxDrink[i - 2], maxDrink[i - 3] + wine[i - 1]) + wine[i], maxDrink[i - 1]);
        }
        System.out.println(maxDrink[number]);
    }
}
