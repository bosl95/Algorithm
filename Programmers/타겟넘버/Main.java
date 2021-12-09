package Programmers.타겟넘버;

public class Main {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int result = solution.solution(
                new int[]{1, 1, 1, 1, 1}, 3
        );
        System.out.println("result = " + result);
    }
}

class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        checkNumber(0, numbers[0], numbers, target);
        checkNumber(0, -numbers[0], numbers, target);
        return answer;
    }

    private void checkNumber(int i, int sum, int[] numbers, int target) {
        if (i == numbers.length - 1) {
            if (sum == target) answer++;
            return;
        }

        checkNumber(i + 1, sum + numbers[i + 1], numbers, target);
        checkNumber(i + 1, sum - numbers[i + 1], numbers, target);
    }
}

class Solution2 {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }

        return dfs(numbers, n + 1, sum + numbers[n], target)
                + dfs(numbers, n+1, sum - numbers[n], target);
    }
}