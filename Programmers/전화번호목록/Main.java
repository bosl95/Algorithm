package Programmers.전화번호목록;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution.solution(new String[]{"123","456","789"}));
        System.out.println(solution.solution(new String[]{"12","123","1235","567","88"}));

    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}