package STACK.Backjoon_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> array = new ArrayList<>();
        IntStream.range(1, n+1).forEach(i -> array.add(i));

        int now = 0;
        int result = 0;
        for (int i = 0; i < m; i++) {
            int findIdx = array.indexOf(Integer.parseInt(st.nextToken()));
            int left = Math.abs(findIdx - now);
            result += Math.min(left, array.size() - left);
            array.remove(findIdx);
            now = findIdx;
        }
        System.out.println(result);
    }
}
