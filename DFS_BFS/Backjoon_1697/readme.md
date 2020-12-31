# [[1697]숨바꼭질](https://www.acmicpc.net/problem/1697)

## BFS/DFS를 이용한 풀이

- BFS로 풀어야하는 문제
- 한칸 앞, 한칸 뒤, 2*x칸 앞 중 제일 최적화 가능성이 높은 2*x칸을 제일 마지막에 실행해주어야한다.
  - 반례
    ```java
    0 3
    ```
    
- 찾아야하는 위치가 같거나 작다면 `현재 위치 - 찾는 위치`로 바로 구해줄 수 있다.

```java
if (n >= k) {
            System.out.println(n - k);
            return;
        }
```