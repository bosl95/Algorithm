package Programmers.큰수만들기;

public class 큰수만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("12", 1));
        System.out.println(solution.solution("1924", 3));
        System.out.println(solution.solution("1924", 2));
        System.out.println(solution.solution("1231234", 3));
        System.out.println(solution.solution("4177252841", 4));
    }

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder st = new StringBuilder();

            int idx = 0;
            int maxvlue = 0;
            for (int i = 0; i < number.length() - k; i++) {
                maxvlue = 0;
                for (int j = idx; j <= i + k; j++) {
                    if (maxvlue < number.charAt(j) - '0') {
                       maxvlue = number.charAt(j) - '0';
                       idx = j + 1;
                    }
                }
                st.append(maxvlue);
            }
            return st.toString();
        }
    }
}
