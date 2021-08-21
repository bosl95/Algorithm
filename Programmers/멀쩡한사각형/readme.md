# [멀쩡한 사각형](https://programmers.co.kr/learn/courses/30/lessons/62048)

## 풀이

![풀이](./파일_001.png)

- `y = ax`의 기울기 a를 구한다.
- x를 대입하면서 나온 값보다 `X.xx`에서 X까지는 사용가능한 사각형
- 대칭이므로 위의 합계에 2배

### 주의사항

```java
public long solution(int w, int h) {
    double a = h / (double) w; // gradient

    long result = 0;
    for (int i = 0; i < w; i++) {
        result += (long) (a * i);
    }

    return 2 * result;
}
```

- 다음과 같이 기울기를 먼저 구해버리면 테스트가 실패한다.
- 기울기는 소수점이 될 수 있는데, 이는 부정확한 결과가 나타날 수 있다.
- 결론은 이 부정확한 결과값에 i를 곱하는 방식은 X
- `i * h`를 먼저 해주고, `w` 나누기를 이후에 해서 소수점 계산을 최대한 뒤로 미룬다.