package Programmers.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int result = solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println("result = " + result);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int current = 0;
        int i = 0;
        while (i < jobs.length || !q.isEmpty()) {
            // i가 job의 길이보다 작으면서 현재 시간이 job[i]의 시작 시간을 넘었을 경우
            while (i < jobs.length && jobs[i][0] <= current) {
                q.add(new int[]{jobs[i][0], jobs[i][1]});
                i ++;
            }

            if (q.isEmpty()) {
                current = jobs[i][0];
            } else {
                int[] temp = q.poll();
                answer += current + temp[1] - temp[0];
                current += temp[1];
            }
        }
        return answer / jobs.length;
    }
}
