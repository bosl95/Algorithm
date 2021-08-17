package Programmers.skilltree;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(result);
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (int i = 0; i < skill_trees.length; i++) {
                if (isCorrect(skill, skill_trees[i])) {
                    System.out.println(skill_trees[i] + "** 당첨");
                    answer += 1;
                }
            }

            return answer;
        }

        private boolean isCorrect(String skill, String skill_tree) {
            int idx = 0;

            for (int i = 0; i < skill_tree.length(); i++) {
                char ch = skill_tree.charAt(i);
                int index = skill.indexOf(ch);
                if (index == -1) continue;
                if (index > idx) return false;
                idx += 1;
            }
            return true;
        }
    }
}
