package Programmers.kakao_2019_튜플;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String input = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        input = input.substring(1, input.length() - 1);
        int[] results = new Solution().solution(input);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
    }

    static class Solution {
        public int[] solution(String input) {
            Set<Integer> results = new HashSet();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '{' || ch == '}' || ch == ',') continue;
                results.add(ch - '0');
            }

            int[] answer = new int[results.size()];
            int i = 0;
            for (Integer result : results) {
                answer[i++] = result;
            }
            return answer;
        }
    }
}
