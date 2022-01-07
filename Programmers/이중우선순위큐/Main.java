package Programmers.이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] results = solution.solution(new String[]{"I 16", "D 1"});
//        int[] results = solution.solution(new String[]{"I 7","I 5","I -5","D -1"});
        for (int result : results) {
            System.out.print(result + " ");
        }
    }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>(); // 최소 -> 최대순 출력
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 -> 최소순 출력

        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            if (st.nextToken().equals("I")) {
                int x = Integer.parseInt(st.nextToken());
                min.add(x);
                max.add(x);
            } else if (!min.isEmpty()) { // 삭제하면서 큐가 비어있지 않으면
                if (st.nextToken().equals("1")) { // 최댓값 삭제
                    Integer x = max.poll();
                    min.remove(x);
                } else {
                    Integer x = min.poll();
                    max.remove(x);
                }
            }
        }

        if (min.isEmpty()) return answer;
        answer[0] = max.poll();
        answer[1] = min.poll();
        return answer;
    }
}
