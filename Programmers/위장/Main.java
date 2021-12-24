package Programmers.위장;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution.solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            if (map.containsKey(kind)) {
                map.put(kind, map.get(kind) + 1);
            } else {
                map.put(kind, 1);
            }
        }

        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}