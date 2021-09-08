package Programmers.입국심사;

import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[]{7, 10}));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);
            long answer = 0;
            long start = times[0];
            long end = n * (long) times[times.length - 1];

            while (start <= end) {
                long mid = (start + end) / 2;

                long passPersonCount = 0;
                for (int time : times) {
                    passPersonCount += (mid / time);
                }

                if (passPersonCount >= n) {
                    answer = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return answer;
        }
    }
}
