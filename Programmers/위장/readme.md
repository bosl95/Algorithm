# [위장]()

## 풀이

- 경우의 수를 다 계산하면 되는 문제

- 다음과 같이 스트림으로 풀 수 있었다. (다른 분의 풀이)

```java
return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
```

