package Programmers.위클리챌린지.부족한금액계산하기;

public class 부족한금액계산하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 20, 1));
    }

    static class Solution {
        public long solution(int price, int money, int count) {
            long trial = 0;
            for (int i = 1; i <= count; i++) {
                trial += i;
            }
            long result = (price * trial) - money;
            return Math.max(result, 0);
        }
    }
}
