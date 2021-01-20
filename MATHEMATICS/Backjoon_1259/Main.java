package MATHEMATICS.Backjoon_1259;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String cmd = br.readLine();
            if (cmd.charAt(0) == '0') break;
            bw.write(palindrome(cmd));
        }
        bw.close();
    }

    private static String palindrome(String str) {
        int len = str.length();
        for (int i=0; i<len/2; i++) {
            if (str.charAt(i) == str.charAt(len -1 - i)) continue;
            return "no\n";
        }
        return "yes\n";
    }
}
