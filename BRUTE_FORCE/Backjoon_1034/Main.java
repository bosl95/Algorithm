package BRUTE_FORCE.Backjoon_1034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] lamp;
    static int[] zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lamp = new int[n][m];
        HashMap<String, Integer> zeroCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                lamp[i][j] = temp.charAt(j) - '0';
            }
            zeroCount.put(temp, zeroCount.getOrDefault(temp, 0) + 1);
        }

        int k = Integer.parseInt(br.readLine());

        List<String> keys = new ArrayList<>(zeroCount.keySet());
        Collections.sort(keys, (e1, e2) -> zeroCount.get(e2).compareTo(zeroCount.get(e1)));

        for (int i = 0; i < keys.size(); i++) {
            int cnt = 0;
            String key = keys.get(i);
            for (char c : key.toCharArray()) {
                if (c == '0') cnt++;
            }

            if (cnt <= k && cnt % 2 == k % 2) {
                System.out.println(zeroCount.get(key));
                return;
            }
        }
        System.out.println(0);
    }
}

/*
1. 같은 모양 행이어야 같은 그룹
2. K 개수보다 해당 행의 0 개수가 작거나 같아야 함
3. K와 0개수 홀/짝 일치
*/