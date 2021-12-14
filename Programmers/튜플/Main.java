package Programmers.튜플;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] result = solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
//        int[] result = solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
//        int[] result = solution.solution("{{20,111},{111}}");
//        int[] result = solution.solution("{{123}}");
        int[] result = solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    public int[] solution(String s) {
        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        PriorityQueue<Tuple> queue = split(s.substring(1, s.length() - 1));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            List<Integer> list = tuple.getList();
            for (Integer value : list) {
                if (!map.containsKey(value)) {
                    answer.add(value);
                    map.put(value, true);
                }
            }
        }

        return answer.stream().mapToInt(ans -> ans).toArray();
    }

    private PriorityQueue<Tuple> split(String line) {
        PriorityQueue<Tuple> tuples = new PriorityQueue<>();
        String[] splits = line.substring(1, line.length() - 1).split("},\\{");
        for (String str : splits) {
            String[] values = str.split(",");
            List<Integer> list = new ArrayList<>();
            for (String s : values) {
                list.add(Integer.valueOf(s));
            }
            tuples.add(new Tuple(list));
        }

        return tuples;
    }

    class Tuple implements Comparable<Tuple> {
        List<Integer> list;

        public Tuple(List<Integer> list) {
            this.list = list;
        }

        public void add(Integer value) {
            list.add(value);
        }

        public List<Integer> getList() {
            return list;
        }

        private int size() {
            return list.size();
        }

        @Override
        public int compareTo(Tuple o) {
            return this.size() - o.size();
        }
    }
}
