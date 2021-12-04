package Programmers.TEST;

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        for (int sol : solution.solution(2, 9)) {
            System.out.print(sol + " ");
        }
        System.out.println();

        for (int sol : solution.solution(2, 1)) {
            System.out.print(sol + " ");
        }
        System.out.println();

        for (int sol : solution.solution(2, 8)) {
            System.out.print(sol + " ");
        }
    }
}

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s/n <= 0) return new int[]{-1};

        int 몫  = s / n;
        int 나머지 = s % n;

        for (int i = n - 1; i >= 0; i--) {
            if (나머지 == 0) {
                answer[i] = 몫;
            } else {
                answer[i] = 몫 + 1;
                나머지--;
            }
        }

        return answer;
    }
}
