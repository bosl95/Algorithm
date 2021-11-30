package Programmers.단어변환;

import java.util.Deque;
import java.util.LinkedList;

public class Q1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        );
        int answer2 = solution.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"}
        );
        System.out.println(answer);
        System.out.println(answer2);
    }

}

class Solution {
    private boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (notInTarget(target, words)) return 0;

        visit = new boolean[words.length];
        Deque<String> deque = new LinkedList<>();
        deque.add(begin);

        while (true) {
            answer++;
            Deque<String> newDeque = new LinkedList<>();
            while (!deque.isEmpty()) {
                String selected = deque.pollFirst();
                for (int i = 0; i < words.length; i++) {
                    if (!visit[i] && diffOnlyOne(words[i], selected)) {
                        visit[i] = true;
                        newDeque.add(words[i]);

                        if (words[i].equals(target)) return answer;
                    }
                }
            }
            deque = newDeque;
        }
    }

    private boolean notInTarget(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) return false;
        }
        return true;
    }

    private boolean diffOnlyOne(String word, String selected) {
        int matchCount = 0;
        for (int i = 0; i < selected.length(); i++) {
            if (word.charAt(i) == selected.charAt(i)) continue;
            matchCount++;
        }
        return matchCount == 1;
    }
}
