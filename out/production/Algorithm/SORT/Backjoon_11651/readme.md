# [[11651]좌표정렬하기](https://www.acmicpc.net/problem/11651)

## Sort를 이용한 풀이

- [[11650]좌표 정렬하기]와 다른 것이 거의 없는 문제이다.
- 하나 알아둘 점은 `System.out.print`의 사용횟수에도 주의를 해야한다는 것이다.

```java
// 시간 초과
for (int i=0; i<n; i++) {
    System.out.print(arr[i][0]+" ");
    System.out.println(arr[i][1]);
}

// 통과
for (int i=0; i<n; i++) {
    System.out.print(arr[i][0]+" "+arr[i][1]);
}
```