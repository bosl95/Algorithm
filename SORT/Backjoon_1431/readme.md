# [[1431]시리얼 번호](https://www.acmicpc.net/problem/1431)

### 문자열 비교하기

```java
Arrays.sort(words, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
            return -1;
        } else if (o1.length() == o2.length()) {
            if (calculate(o1) == calculate(o2)) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(calculate(o1), calculate(o2));
            }
        } else {
            return 1;
        }
    }
```

- 사전 순으로 문자열 비교 : `str1.compareTo(str2)`