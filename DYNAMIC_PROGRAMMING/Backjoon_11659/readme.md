# [[11659]구간 합 구하기 4](https://www.acmicpc.net/problem/11659)

## Dynamic Programming을 이용한 풀이

- 각 구간의 누적 합을 계산한다.
- i번째부터 j번째까지 합을 출력한다
  - j번째까지의 누적합에서 i번째의 누적합을 빼서 (i, j) 구간의 합계를 구할 수 있다.