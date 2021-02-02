# [[1799]비숍](https://www.acmicpc.net/problem/1799)

## Backtracking을 이용한 풀이

- 비숍은 자신의 위치에서 대각선에 해당하는 위치만 관련이 있다.
- 따라서 보드판을 흑백으로 나누어 따로 계산해주어야하는 문제

<image src='https://t1.daumcdn.net/cfile/tistory/99534B4C5A6EFFF91D' width='60%'>  

- 검은칸을 DFS로 계산하고 흰칸들을 DFS로 따로따로 계산해준다.