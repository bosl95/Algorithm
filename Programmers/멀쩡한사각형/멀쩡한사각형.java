package Programmers.멀쩡한사각형;

public class 멀쩡한사각형 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(9, 12));
    }

    static class Solution {
        public long solution(int w, int h) {
            long result = 0;
            for (int i = 0; i < w; i++) {
                result += (long) h * i / w;
            }
            return 2 * result;
        }
    }
}
