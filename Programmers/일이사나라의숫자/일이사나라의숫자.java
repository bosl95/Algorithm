package Programmers.일이사나라의숫자;

public class 일이사나라의숫자 {

    public static void main(String[] args) {
        String result = new Solution().solution(9);
        System.out.println(result);
    }

    static class Solution {

        String[] array = {"4", "1", "2", "4"};

        public String solution(int n) {
            return convert(n);
        }

        private String convert(int n) {
            if (n < 4) return array[n];
            int a = n / 3;
            int b = n % 3;

            if (b == 0) a--;
            String result = a > 3 ? convert(a) : array[a];
            return result + array[b];
        }
    }
}
