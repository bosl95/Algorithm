package SORT.Backjoon_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder[] stringBuilder = new StringBuilder[201];

        for (int i=0; i<stringBuilder.length; i++) {
            stringBuilder[i] = new StringBuilder();
        }

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            stringBuilder[age].append(age).append(" ").append(name).append("\n");
        }

        for (StringBuilder i : stringBuilder) {
            System.out.print(i);
        }
    }
}
