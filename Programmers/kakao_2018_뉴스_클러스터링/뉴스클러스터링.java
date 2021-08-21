package Programmers.kakao_2018_뉴스_클러스터링;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("FRANCE", "french"));
    }

    static class Solution {
        public int solution(String str1, String str2) {
            List<String> strSet1 = makeWordList(str1);
            List<String> strSet2 = makeWordList(str2);

            List<String> intersection = new ArrayList<>();
            List<String> union = new ArrayList<>();

            for (String str : strSet1) {
                if (strSet2.remove(str)) {
                    intersection.add(str);
                }
                union.add(str);
            }

            union.addAll(strSet2);
            if (union.size() == 0) return 65536;

            double result = (double) intersection.size() / (double) union.size();
            return (int) (result * 65536);
        }

        private static List<String> makeWordList(String values) {
            List<String> result = new ArrayList<>();
            int len = values.length();
            values = values.toLowerCase();
            char[] words = new char[2];
            for (int i = 0; i < len - 1; i++) {
                words[0] = values.charAt(i);
                words[1] = values.charAt(i + 1);
                if (!isAlphabet(words[0]) || !isAlphabet(words[1])) continue;
                result.add(new String(words));
            }
            return result;
        }

        private static boolean isAlphabet(char ch) {
            return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
        }
    }
}
