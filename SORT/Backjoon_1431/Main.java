package SORT.Backjoon_1431;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    if (calculate(o1) == calculate(o2)) {
                        return o1.compareTo(o2);
                    } else {
                        return Integer.compare(calculate(o1), calculate(o2));
                    }
                } else {
                    return 1;
                }
            }

            private int calculate(String value) {
                int sum = 0;
                for (int i = 0; i < value.length(); i++) {
                    char c = value.charAt(i);
                    if (c >= '0' && c <= '9') {
                        sum += (c - '0');
                    }
                }
                return sum;
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(words[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
