# [[9252]LCS2](https://www.acmicpc.net/problem/9252)

## Dynamic Programming을 이용한 풀이

- 이전 [[9251]LCS](https://github.com/bosl95/Algorithm/tree/master/DYNAMIC%20PROGRAMMING/%5B9251%5DLCS)의 다른 버전의 문제
- 처음에 위의 버전이랑 숫자까지 똑같이 다 세준 다음 글자를 구해주는 방법으로 풀려고 했는데, 굳이 그렇게 안하고 바로 dp 배열에 문자를 삽입해서 구해줄 수 있는 단순한 풀이가 있었다.
- LCS 문제에서 숫자를 통해 비교한게 즉 문자의 길이이므로 현재 dp에 삽입된 문자열 길이를 비교해서 풀어주면 쉽게 풀 수 있다.

