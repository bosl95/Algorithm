package Programmers.소수만들기;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 2, 7, 6, 4});
        System.out.println("result = " + result);
    }
}

class Solution {
    static int answer;

    public int solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            add(1, i, nums[i], nums);
        }
        return answer;
    }

    private void add(int num, int i, int result, int[] nums) {
        if (num == 3) {
            if (isPrime(result)) answer++;
            return;
        }

        for (int j = i + 1; j < nums.length; j++) {
            add(num + 1, j, result + nums[j], nums);
        }
    }

    private boolean isPrime(int result) {
        for (int i = 2; i < result / 2; i++) {
            if (result % i == 0) return false;
        }
        return true;
    }
}
