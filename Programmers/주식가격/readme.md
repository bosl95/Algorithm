# [주식 가격](https://programmers.co.kr/learn/courses/30/lessons/42584)

## 풀이

- Stack을 이용해 풀어야하는 문제

```java
for (int i = 0; i < prices.length; i++) {
    while (!queue.isEmpty() && prices[queue.peekLast()] > prices[i]) {
        Integer index = queue.pollLast();
        seconds[index] = i - index;
    }
    queue.add(i);
}

while (!queue.isEmpty()) {
    Integer index = queue.pollLast();
    seconds[index] = prices.length - index - 1;
}
```

- 다음과 같이 스택 맨 마지막(peek)에 있는 값과 현재 방문하고 있는 위치(i)의 값을 비교하여 스택 마지막의 값이 더 큰 경우 가격이 떨어지는 것임을 판별
- 현 위치(i)에서 스택 맨마지막에 있는 값의 위치(peek)을 뺀 값을 prices[peek]에 넣어준다.
- 모든 방문이 끝나고 스택에 남은 값들은 prices가 다 방문할때까지도 가격이 떨어지지 않은 경우 이므로 n-1을 기준으로 해당 값들의 위치(peek)를 뺀 값을 넣어준다.