# [베스트 앨범](https://programmers.co.kr/learn/courses/30/lessons/42579)

## 풀이

```java
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumOfGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            sumOfGenres.put(genres[i], sumOfGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genre = new ArrayList<>(sumOfGenres.keySet());
        Collections.sort(genre, ((o1, o2) -> sumOfGenres.get(o2) - sumOfGenres.get(o1)));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);

            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                // 해당 장르 음악 중 play 횟수가 가장 큰 인덱스 찾기
                if (g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                // 해당 장르 음악 중 play 횟수가 가장 큰 인덱스 찾기
                if (g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }
            list.add(firstIdx);
            if (secondIdx >= 0) list.add(secondIdx);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```

- 런타임 에러가 계속 발생해 다른 사람의 풀이를 봤다.

```java
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumOfGenres = new HashMap<>();
        Map<String, List<Integer>> playList = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (sumOfGenres.containsKey(genre)) {
                sumOfGenres.put(genre, sumOfGenres.get(genre) + plays[i]);
                playList.get(genre).add(i);
            } else {
                sumOfGenres.put(genre, plays[i]);
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                playList.put(genre, temp);
            }
        }

        List<String> keySet = new ArrayList<>(sumOfGenres.keySet());
        Collections.sort(keySet, (o1, o2) -> sumOfGenres.get(o2) - sumOfGenres.get(o1));

        int[] answer = new int[sumOfGenres.size() * 2];
        int idx = 0;
        for (String key : keySet) {
            List<Integer> songs = playList.get(key);
            Collections.sort(songs, Comparator.comparingInt(a -> plays[a]));
            int n = songs.size();
            answer[idx++] = songs.get(n - 1);
            answer[idx++] = songs.get(n - 2);
        }

        return answer;
    }

}
```

- 위의 코드는 런타임이 났던 코드
- 플레이리스트를 우선 다 넣고 정렬하는 것보다 장르를 미리 파악한 후 (합계도 먼저 계산), 반복문을 두번 쓰는 것이 좀 더 적절하다.


```java
List<String> keySet = new ArrayList<>(sumOfGenres.keySet());
        Collections.sort(keySet, (o1, o2) -> sumOfGenres.get(o2) - sumOfGenres.get(o1));

        int[] answer = new int[sumOfGenres.size() * 2];
        int idx = 0;
        for (String key : keySet) {
            List<Integer> songs = playList.get(key);
            Collections.sort(songs, Comparator.comparingInt(a -> plays[a]));
            int n = songs.size();
            answer[idx++] = songs.get(n - 1);
            answer[idx++] = songs.get(n - 2);
        }
```

- 나의 풀이를 보면 이 부분에서도 O(n)이 많이 발생한 뿐만 아니라 O(n^2) 또한 발생한다.
  - 반면 정답 코드는 중복이 사라진 장르 개수이기 때문에 내 풀이보다 훨씬 적은 탐색이 발생한다.  