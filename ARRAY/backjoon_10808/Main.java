package ARRAY.backjoon_10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] num = new int[26];

        String word = br.readLine();
        for (int i=0; i<word.length(); i++) {
            num[word.charAt(i)-97]++;
        }

        for (int i=0; i<26; i++) {
            sb.append(num[i]);
            sb.append(" ");
        }
        System.out.print(sb.toString());
    }
}
