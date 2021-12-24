package Programmers.베스트앨범;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] result = solution.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        );
        Arrays.stream(result)
                .forEach(r -> System.out.print(r + " "));
    }
}

//class Solution {
//    public int[] solution(String[] genres, int[] plays) {
//        Map<String, Integer> sumOfGenres = new HashMap<>();
//        for (int i = 0; i < genres.length; i++) {
//            sumOfGenres.put(genres[i], sumOfGenres.getOrDefault(genres[i], 0) + plays[i]);
//        }
//
//        ArrayList<String> genre = new ArrayList<>(sumOfGenres.keySet());
//        Collections.sort(genre, ((o1, o2) -> sumOfGenres.get(o2) - sumOfGenres.get(o1)));
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < genre.size(); i++) {
//            String g = genre.get(i);
//
//            int max = 0;
//            int firstIdx = -1;
//            for (int j = 0; j < genres.length; j++) {
//                // 해당 장르 음악 중 play 횟수가 가장 큰 인덱스 찾기
//                if (g.equals(genres[j]) && max < plays[j]) {
//                    max = plays[j];
//                    firstIdx = j;
//                }
//            }
//
//            max = 0;
//            int secondIdx = -1;
//            for (int j = 0; j < genres.length; j++) {
//                // 해당 장르 음악 중 play 횟수가 가장 큰 인덱스 찾기
//                if (g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
//                    max = plays[j];
//                    secondIdx = j;
//                }
//            }
//            list.add(firstIdx);
//            if (secondIdx >= 0) list.add(secondIdx);
//        }
//
//        int[] answer = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i);
//        }
//        return answer;
//    }
//}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumOfGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            sumOfGenres.put(genres[i], sumOfGenres.getOrDefault(genres[i], 0) + plays[i]);
        }


        List<String> keySet = new ArrayList<>(sumOfGenres.keySet());
        Collections.sort(keySet, (o1, o2) -> sumOfGenres.get(o2) - sumOfGenres.get(o1));

        List<Integer> playList = new ArrayList<>();
        for (int i = 0; i < keySet.size(); i++) {
            String genre = keySet.get(i);

            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                // 해당 장르 음악 중 play 횟수가 가장 큰 인덱스 찾기
                if (genre.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                // 해당 장르 음악 중 play 횟수가 가장 큰 인덱스 찾기
                if (genre.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }
            playList.add(firstIdx);
            if (secondIdx >= 0) playList.add(secondIdx);
        }

        int[] answer = new int[playList.size()];
        for (int i = 0; i < playList.size(); i++) {
            answer[i] = playList.get(i);
        }

        return answer;
    }
}