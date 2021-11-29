package Programmers.불량사용자;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int answer = solution.solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "abc1**"}
        );
        System.out.println(answer);

        Solution2 solution2 = new Solution2();
        int answer2 = solution2.solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "*rodo", "******", "******"}
        );
        System.out.println(answer2);
    }
}

class Solution2 {
    boolean[] visit;
    Set<String> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        visit = new boolean[user_id.length];

        findCase(0, user_id, banned_id, new ArrayList<>());

        return answer.size();
    }

    private void findCase(int num, String[] user_id, String[] banned_id, List<String> list) {
        if (num == banned_id.length) {
            answer.add(Arrays.toString(visit));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visit[i] && isBanned(user_id[i], banned_id[num])) {
                visit[i] = true;
                list.add(user_id[i]);
                findCase(num + 1, user_id, banned_id, list);
                visit[i] = false;
                list.remove(user_id[i]);
            }
        }
    }

    public boolean isBanned(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) return false;

        for (int i = 0; i < user_id.length(); i++) {
            if (banned_id.charAt(i) != '*' && user_id.charAt(i) != banned_id.charAt(i)) return false;
        }

        return true;
    }
}
