# [불량 사용자](https://programmers.co.kr/learn/courses/30/lessons/64064?language=java)

## 풀이

- 각 불량 사용자 아이디 목록 별로 선택할 수 있는 아이디를 고른다. (findCase)
- 각 불량 사용자 별로 고른 아이디 리스트가 이미 선택한 적 있는 경우라면 제외한다.
  - `Set<String> answer = new HashSet<>();`
  - `answer.add(Arrays.toString(visit));`
  - answer를 Set으로 관리.