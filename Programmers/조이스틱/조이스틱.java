package Programmers.조이스틱;

public class 조이스틱 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("JEROEN"));
        System.out.println(solution.solution("JAN"));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int length = name.length();
            int minMove = length - 1;

            for (int i = 0; i < length; i++) {
                char ch = name.charAt(i);
                int diff = Math.min(ch - 'A', 'Z' - ch + 1);
                answer += diff;

                int next = i + 1;
                while (next < length && name.charAt(next) == 'A') {
                    next++;
                }

                minMove = Math.min(minMove, i  + i  + length - next);
            }

            answer += minMove;

            return answer;
        }
    }
}
