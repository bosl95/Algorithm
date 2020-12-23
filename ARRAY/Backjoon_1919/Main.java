package ARRAY.Backjoon_1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int a1[] = new int[26];
        int a2[] = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            a1[str1.charAt(i)-97]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            a2[str2.charAt(i)-97]++;
        }

        int result = 0;
        for (int i=0; i<26; i++) {
            result += Math.abs(a1[i]-a2[i]);
        }
        System.out.println(result);
    }
}
