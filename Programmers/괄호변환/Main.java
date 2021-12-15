package Programmers.괄호변환;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution("(()())()"));
//        System.out.println(solution.solution(")("));
        System.out.println(solution.solution("()))((()"));
    }
}

class Solution {
    public String solution(String p) {
        if (isCorrect(p)) {
            return p;
        }
        return split(p);
    }

    private String split(String w) {
        if (w.length() == 0) return "";

        String u = "";
        String v = "";
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c == '(') cnt1++;
            else cnt2++;

            if ((cnt1 != 0 && cnt2 != 0) && cnt1 == cnt2) {
                u = w.substring(0, i + 1);
                if (i != w.length() - 1) {
                    v = w.substring(i + 1);
                }
                break;
            }
        }

        if (!isCorrect(u)) {
            String result = "(" + split(v) + ")";
            for (int i = 1; i < u.length() - 1; i++) {
                result += u.charAt(i) == '(' ? ")" : "(";
            }
            return result;
        } else {
            return u + split(v);
        }
    }

    private boolean isCorrect(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) return false;
                else count--;
            }
        }
        return count == 0;
    }
}