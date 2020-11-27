package SORT.Backjoon_1181;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class backjoon_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());

        String[] stringArray = new String[number];

        for (int i=0; i<number; i++) {
            stringArray[i] = br.readLine();
        }

        Arrays.sort(stringArray, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }

                return s1.length() - s2.length();
            }
        });

        for (int i=0; i<number; i++) {
            if(i>0 && stringArray[i-1].equals(stringArray[i])) continue;

            bw.write(stringArray[i]);
            bw.newLine();
        }

        bw.flush();
    }
}