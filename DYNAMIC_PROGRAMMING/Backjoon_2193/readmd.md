# [[2193]이친수](https://www.acmicpc.net/problem/2193)

## Dynamic Programming을 이용한 풀이

- f(i) : i자리의 이친수의 개수라 가정,
- f(1) = 1
- f(2) = 1
- f(3) = 2
- f(4) = 3
- ....


### 다른 풀이

```
이친수
N자리 이친수의 개수
N == 1)
- 1 (1개)
N == 2)
- 1,0 (1개)
N == 3)
- 1,0,0 / 1,0,1 (2개)
N == 4)
- 1,0,0,0 / 1,0,0,1 / 1,0,1,0 (3개)
```