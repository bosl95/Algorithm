package SIMULATION.Backjoon_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Gear> gears;
    private static boolean[] visit = new boolean[4];

    static class Gear {
        List<String> deque = new ArrayList<>();

        public Gear(String[] values) {
            deque.addAll(Arrays.asList(values));
        }

        public void move(int button) {
            Collections.rotate(deque, button);
        }

        public boolean notSame(String value, boolean leftGear) {
            if (leftGear) {
                return !deque.get(6).equals(value);
            }
            return !deque.get(2).equals(value);
        }

        public boolean isSPole() {
            return deque.get(0).equals("1");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            gears.add(new Gear(br.readLine().split("")));
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;     // index
            int dir = Integer.parseInt(st.nextToken());
            checkGear(num, dir);
            Arrays.fill(visit, false);
        }

        int score = 1;
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).isSPole()) result += score;
            score *= 2;
        }
        System.out.println(result);
    }

    private static void checkGear(int num, int dir) {
        Gear gear = gears.get(num);
        visit[num] = true;

        if (num - 1 >= 0 && !visit[num - 1]) {
            if (gear.notSame(gears.get(num - 1).deque.get(2), true)) {
                checkGear(num - 1, -dir);
            }
        }

        if (num + 1 < 4 && !visit[num + 1]) {
            if (gear.notSame(gears.get(num + 1).deque.get(6), false)) {
                checkGear(num + 1, -dir);
            }
        }
        gears.get(num).move(dir);
    }
}
