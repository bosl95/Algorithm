# [문자열 압축](https://programmers.co.kr/learn/courses/30/lessons/60057?language=java)

## 풀이

```java
for (int size = 1; size <= s.length() / 2; size++) {
    int length = getLengthWhenSliceBy(size, s).length();
    answer = Math.min(answer, length);
}
```

- `size` : 비교할 문자열 단위.  
- 최대 `s.length()/2`까지 가능  

  
  
```java
private String getLengthWhenSliceBy(int size, String s) {
    int count = 1;
    String pre = "";
    StringBuilder result = new StringBuilder();

    for (int i = 0; i <= s.length() + size; i += size) {
        String now;

        if (i >= s.length()) { // 문자열이 없는 경우
            now = "";
        } else if (s.length() < i + size) { // 마지막 문자열인 경우
            now = s.substring(i);
        } else {
            now = s.substring(i, i + size);
        }

        if (i != 0) { // 맨처음이 아닌 경우
            if (now.equals(pre)) { // 이전 문자열과 같은 경우
                count += 1;
            } else if (count >= 2) { // 이전 문자열과 다르고 count가 2회 이상이라면 압축
                result.append(count).append(pre);
                count = 1;
            } else {    // 압축이 불가능한 경우 이어 붙이기
                result.append(pre);
            }
        }

        pre = now;
    }

    return result.toString();
}
```

- `getLengthWhenSliceBy()` : 문자열을 자를 단위를 받아 해당 단위만큼 문자열 압축

```java
for (int i = 0; i <= s.length() + size; i += size)
```

- size만큼 증가한다.
- i는 비교 대상 문자열(`now`)의 첫 시작위치를 나타낸다.
- `i <= s.length() + size` 인 이유?
  - `[i, i + size]` 범위의 문자열(`now`)과 `[i - size, i]`의 문자열(`pre`)을 비교하는데 비교 결과에 대하여 `[i - size, i]`의 문자열(`pre`)을 처리해주기 때문

  
  
```java
if (i >= s.length()) { // 문자열이 없는 경우
    now = "";
} else if (s.length() < i + size) { // 마지막 문자열인 경우
    now = s.substring(i);
} else {
    now = s.substring(i, i + size);
}
```

- 앞에서 말했던 `now`는 s.length 길이를 초과할 수 있다. (`pre` 처리를 위한 문자열이므로)
- `i >= s.length()` : 문자열이 없는 경우
- `s.length() < i + size` : 마지막 문자열인 경우 (더이상 문자열 단위로 자를 수 없을 만큼 작은 경우)
- 그외 : 정상적으로 문자열 단위를 자를 수 있는 경우

  
  

```java
if (i != 0) { // 맨처음이 아닌 경우
    if (now.equals(pre)) { // 이전 문자열과 같은 경우
        count += 1;
    } else if (count >= 2) { // 이전 문자열과 다르고 count가 2회 이상이라면 압축
        result.append(count).append(pre);
        count = 1;
    } else {    // 압축이 불가능한 경우 이어 붙이기
        result.append(pre);
    }
}

pre = now;
```

- 문자열이 맨처음인 경우는 바로 `pre`에 `now`를 넣는다.
- 문자열이 맨처음이 아닌 경우 `pre`와 `now`를 비교한다.
  - `pre`와 `now`가 같은 경우  : count를 1 증가
  - `pre`와 `now`가 다른 경우
    - count가 2 이상인 경우 : `pre`와 동일하게 잘린 단어가 여러개라는 의미 => 압축 가능
    - count가 1인 경우 : `pre`가 단 1개밖에 존재하지 않음  => 압축 불가능

### 주의사항

- `aabababc` 다음과 같은 문자열이 있다고 했을 때 `a3abc`로 압축될 수 있다고 생각했는데 그게 아니었다. ㅠㅠ 

```
문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.
```

