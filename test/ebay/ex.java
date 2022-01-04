package ebay;

import java.util.ArrayList;
import java.util.List;

public class ex {
//
//    class Solution8 {
//        private int removeCount = 0;
//
//        public String[] solution(String []P) {
//            List<Integer> answers = new ArrayList<>();
//            for (int i = 1; i < P.length; i++) {
//                boolean[] check = new boolean[P.length];
//                removeCount = 0;
//                if (findCase(P, 0, i, check)) {
//                    answers.add(i);
//                }
//            }
//
//            int leng = answers.size();
//            String[] answer = new String[leng];
//            for (int i = 0; i < leng; i++) {
//                answer[i] = P[answers.get(i)];
//            }
//
//            return answer;
//        }
//
//        private boolean findCase(String[] P, int idx1, int idx2, boolean[] check) {
//            if (!isPallin(P[idx1] + P[idx2]) && !isPallin(P[idx2] + P[idx1])) return false;
//            check[idx1] = true;
//            check[idx2] = true;
//            removeCount += 2;
//
//            if (removeCount == P.length) {
//                return true;
//            }
//
//            for (int i = 1; i < P.length - 1; i++) {
//                for (int j = i; j < P.length; j++) {
//                    if (i!=j && !check[i] && !check[j]) {
//                        return findCase(P, i, j, check);
//                    }
//                }
//            }
//
//            check[idx1] = false;
//            check[idx2] = false;
//            removeCount -= 2;
//            return false;
//        }
//
//        public static boolean isPallin(String input) {
//            int len = input.length();
//
//            for (int i = 0; i < len; i++) {
//                if (input.charAt(i) != input.charAt(len - i - 1)) {
//                    return false;
//                }
//            }
//
//            return true;
//        }
//    }
}
