# [튜플](https://programmers.co.kr/learn/courses/30/lessons/64065)

## 다른 사람의 풀이

```java
class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
```

### 유의해서 보기
- split하는 부분에서 저렇게도 풀 수 있겠다라는 점
- 메모리를 최대한 사용하지 않는 배열을 최대한 활용한다는 점