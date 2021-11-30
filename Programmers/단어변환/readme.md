# [단어 변환](https://programmers.co.kr/learn/courses/30/lessons/43163)

## 풀이

- BFS로 풀었다. 
- begin 단어부터 시작해서 바꿀 수 있는 알파벳을 탐색한다.
- 탐색할때마다 count++
- 결국 target 단어에 도달하는 경우 count를 반환