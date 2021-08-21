package Programmers.오픈채팅방;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = getResult(solution);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static String[] getResult(Solution solution) {
        return solution.solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        });
    }

    static class Solution {
        public String[] solution(String[] record) {
            Map<String, String> user = new HashMap<>();
            List<String[]> flows = new ArrayList<>();

            for (int i = 0; i < record.length; i++) {
                String[] input = record[i].split(" ");
                if (record[i].startsWith("Enter")) {
                    flows.add(new String[]{input[1], "님이 들어왔습니다."});
                } else if (record[i].startsWith("Leave")) {
                    flows.add(new String[]{input[1], "님이 나갔습니다."});
                    continue;
                }

                user.put(input[1], input[2]);
            }

            return flows.stream()
                    .map(flow -> user.get(flow[0]) + flow[1])
                    .toArray(String[]::new);
        }
    }
}
