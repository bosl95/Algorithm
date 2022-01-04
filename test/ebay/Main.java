package ebay;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 2번
//        final Solution2 solution2 = new Solution2();
//        System.out.println(solution2.solution(new int[]{1, 3, 2}, 3));

        // 4번
        final Solution4 solution4 = new Solution4();
//        System.out.println(solution4.solution(6, 3, "RBGRGB"));
//        System.out.println(solution4.solution(3, 2, "BGG"));
        System.out.println(solution4.solution(4, 2, "GBBG"));

        // 5번
//        final Solution5 solution5 = new Solution5();
//        final String[] results = solution5.solution(new String[]{"11", "111", "11", "211"});
//        final String[] results = solution5.solution(new String[]{"21","123","111","11"});
//        for (String result : results) {
//            System.out.print(result + " ");
    }
}


class Solution1 {
//    Map<String, Integer> day = Map.of(
//            "MO", 0,
//            "TU", 1,
//            "WE", 2,
//            "TH", 3,
//            "FR", 4
//    );

    public int solution(String[][] schedule) {
        int answer = -1;
        Map<String, Map<String, List<Integer>>> map = new HashMap<>(); // 0분과 30분 2칸
        map.put("MO", new HashMap<>());
        map.put("TU", new HashMap<>());
        map.put("WE", new HashMap<>());
        map.put("TH", new HashMap<>());
        map.put("FR ", new HashMap<>());

        for (int i = 0; i < schedule.length; i++) {

        }

        return answer;

    }
}

//class Solution2 {
//    // 하나의 돌무더기 선택 + 1 나머지는 돌무더기 -1
//    // -1할 돌무더기가 없는 경우 실행 불가
//    Set<String> answers = new HashSet<>();
//
//    public String solution(int[] stones, int k) {
//        String answer = "";
//
//        for (int i = 0; i < stones.length; i++) {
//            // 돌무더기 하나를 고른다.
//            findCase(i, stones, k, String.valueOf(i));
//        }
//
//        return answer;
//    }
//
//    private void findCase(int i, int[] stones, int k, String result) {
//        boolean correct = false;
//        for (int j = 0; j < stones.length; j++) {
//            if (j == i) { // 선택한 돌무더기일 경우
//                stones[i] += 1;
//                if (stones[i] == k) {
//                    correct = true;
//                }
//            } else {
//                if (stones[i] == 0) { // 만약 돌무더기를 제거할 수 없다면
//                    correct = false; // 제거될 수 없는 경우이므로 k가 되었더라도 취소
//                    break;
//                }
//                stones[i] -= 1;
//            }
//        }
//
//        if (correct) { // 만약 k에 도달했다면
//            answers.add(result + i);
//        }
//
//        for (int j = 0; j < stones.length; j++) {
//            findCase(j, stones, k, result);
//        }
//    }
//}

// 무한 반복 되는 경우가 언제인지?
class Solution4 {
    private Map<String, Integer> set = new HashMap<>();
    private int answer = Integer.MAX_VALUE;

    public int solution(int n, int k, String bulbs) {
        int redCount = 0;
        for (int i = 0; i < n; i++) {
            if (bulbs.charAt(i) == 'R') redCount++;
        }

        System.out.println("시작 :" + bulbs);
        for (int i = 0; i < n - k; i++) {
            System.out.println(i + " 부터 " + (i + k - 1) + "까지 클릭 : ");
            changeBulbs(i, n, k, bulbs.toCharArray(), 1, redCount);
        }

        return answer;
    }

    private void changeBulbs(int i, int n, int k, char[] bulbs, int trial, int redCount) {
        for (int j = i; j < i + k; j++) {
            bulbs[j] = changeColor(bulbs[j]);
            if (bulbs[j] == 'R') redCount += 1;
        }

        final String s = new String(bulbs);
        System.out.println("클릭 결과  : " + s);
        if (set.containsKey(s) && set.get(s) <= trial) {
            for (int j = i; j < i + k; j++) {
                if (bulbs[j] == 'R') redCount -= 1;
                bulbs[j] = changeColorReverse(bulbs[j]);
            }
            return;
        }
        else set.put(s, trial);

        if (redCount == n) {
            answer = Math.min(trial, answer);
            System.out.println(trial + " 번만에 성공 ******** ");
            return;
        }

        for (int j = 0; j < n - k; j++) {
            System.out.print("[" + trial + "] " + j + " 부터 " + (j + k) + "까지");
            changeBulbs(j, n, k, bulbs, trial + 1, redCount);
        }

        for (int j = i; j < i + k; j++) {
            if (bulbs[j] == 'R') redCount -= 1;
            bulbs[j] = changeColorReverse(bulbs[j]);
        }
    }

    private char changeColorReverse(char input) {
        if (input == 'G') return 'R';
        else if (input == 'B') return 'G';
        else return 'B';
    }

    private char changeColor(char input) {
        if (input == 'R') return 'G';
        else if (input == 'G') return 'B';
        else return 'R';
    }
}

//class Solution5 {
//
//    private int removeCount = 0;
//    private Set<Integer> ansIdx = new HashSet<>();
//
//    public String[] solution(String[] P) {
//        for (int i = 1; i < P.length; i++) {
//            boolean[] check = new boolean[P.length];
//            System.out.println(0 + " : " + i + " 제거부터 시작");
//            removeCount = 0;
//            findCase(P, 0, i, check, i);
//        }
//
//        String[] answer = new String[ansIdx.size()];
//        int i = 0;
//        final Iterator<Integer> iterator = ansIdx.iterator();
//        while (iterator.hasNext()) {
//            answer[i++] = P[iterator.next()];
//        }
//
//        return answer;
//    }
//
//    private void findCase(String[] P, int idx1, int idx2, boolean[] check, int firstIndex) {
//        if (!isPallin(P[idx1] + P[idx2]) && !isPallin(P[idx2] + P[idx1])) return;
//        System.out.println(idx1 + ", " + idx2 + " 제거");
//        check[idx1] = true;
//        check[idx2] = true;
//        removeCount += 2;
//
//        if (removeCount == P.length) {
//            ansIdx.add(firstIndex);
//            System.out.println("add " + firstIndex);
//            return;
//        }
//
//        for (int i = 1; i < P.length - 1; i++) {
//            for (int j = i; j < P.length; j++) {
//                if (i!=j && !check[i] && !check[j]) {
//                    findCase(P, i, j, check, firstIndex);
//                }
//            }
//        }
//
//        check[idx1] = false;
//        check[idx2] = false;
//        removeCount -= 2;
//    }
//
//    public static boolean isPallin(String input) {
//        int len = input.length();
//
//        for (int i = 0; i < len; i++) {
//            if (input.charAt(i) != input.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}

