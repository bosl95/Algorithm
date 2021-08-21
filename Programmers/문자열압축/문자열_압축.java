package Programmers.문자열압축;

public class 문자열_압축 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbaccc"));
        System.out.println(solution.solution("ababcdcdababcdcd"));
        System.out.println(solution.solution("abcabcdede"));
        System.out.println(solution.solution("abcabcabcabcdededededede"));
        System.out.println(solution.solution("xababcdcdababcdcd"));
    }

    static class Solution {
        public int solution(String s) {
            int answer = s.length();

            for (int size = 1; size <= s.length() / 2; size++) {
                System.out.println(getLengthWhenSliceBy(2, s));
                int length = getLengthWhenSliceBy(size, s).length();
                answer = Math.min(answer, length);
            }
            return answer;
        }

        private String getLengthWhenSliceBy(int size, String s) {
            int count = 1;
            String pre = "";
            StringBuilder result = new StringBuilder();

            for (int i = 0; i <= s.length() + size; i += size) {
                String now;

                if (i >= s.length()) { // 문자열이 없는 경우
                    now = "";
                } else if (s.length() < i + size) { // 마지막 문자열인 경우
                    now = s.substring(i);
                } else {
                    now = s.substring(i, i + size);
                }

                if (i != 0) { // 맨처음이 아닌 경우
                    if (now.equals(pre)) { // 이전 문자열과 같은 경우
                        count += 1;
                    } else if (count >= 2) { // 이전 문자열과 다르고 count가 2회 이상이라면 압축
                        result.append(count).append(pre);
                        count = 1;
                    } else {    // 압축이 불가능한 경우 이어 붙이기
                        result.append(pre);
                    }
                }

                pre = now;
            }

            return result.toString();
        }
    }
}
