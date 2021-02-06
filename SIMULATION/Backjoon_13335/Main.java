package SIMULATION.Backjoon_13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, w, L, time, weight;
    static int START = 1, WAIT = -1, END = -2;
    static int[] truck, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 트럭 개수
        w = Integer.parseInt(st.nextToken());   // 다리 길이
        L = Integer.parseInt(st.nextToken());   // 최대 하중
        truck = new int[n];
        check = new int[n];
        Arrays.fill(check, WAIT);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        while (check[n - 1] != END) {
            time++;
            for (int i = 0; i < n; i++) {
                if (check[i] == END) continue; // 트럭이 이미 지나간 상태
                else if (check[i] == WAIT) break; // 트럭이 아직 다리를 지나지 못한 상태

                if (w <= check[i]) {
                    weight -= truck[i];
                    check[i] = END;
                } else {
                    check[i]++;
                }
            }

            if (idx < n && weight + truck[idx] <= L) {
                weight += truck[idx];
                check[idx++] = START;
            }
        }
        System.out.println(time);
    }
}
