package SORT.Backjoon_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Long[] cards = new Long[num];
        for (int i = 0; i < num; i++) {
            cards[i] = Long.valueOf(br.readLine());
        }

        Arrays.sort(cards);

        int maxIdx = 0;
        int count = 1, max = 1;

        for (int i = 1; i < num; i++) {
            if (cards[i - 1].equals(cards[i])) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                maxIdx = i;
            }
        }

        System.out.println(cards[maxIdx]);
    }
}
