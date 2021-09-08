# [[입국 심사]](https://programmers.co.kr/learn/courses/30/lessons/43238)

## 풀이

- 경과 시간을 기준으로 판단

- n = 5 이고, 심사대가 7분/10분이라고 했을 때
  
    - 첫번째 : 7분 or 10분 심사대 중 7분 심사대 선택 -> 7분에서 14분으로 변경
    - 두번째 : 14분 or 10분 심사대 중 10분 심사대 선택 -> 10분에서 20분으로 변경
    - 세번째 : 14분 or 20분 심사대 중 14분 심사대 선택 -> 14분에서 21분으로 변경
    - 네번째 : 21분 or 20분 심사대 중 20분 심사대 선택 -> 20분에서 30분으로 변경
    - 다섯번째 : 21분 or 30분 심사대 중 21분 심사대 선택 -> 21분에서 28분으로 변경
    - 결과 : 28분/30분 이므로 28분 출력
  
## 첫번째 시도

```java
package Programmers.입국심사;

import java.util.PriorityQueue;

public class 입국심사 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[]{7, 10}));
    }

    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            PriorityQueue<WaitTime> queue = new PriorityQueue<>();
            for (int i = 0; i < times.length; i++) {
                WaitTime waitTime = new WaitTime(times[i], i);
                queue.add(waitTime);
            }

            for (int i = 0; i < n; i++) {
                WaitTime select = queue.poll();
                answer = select.getEndTime();
                select.addTime(times[select.getIndex()]);
                queue.add(select);
            }

            return answer;
        }
    }

    static class WaitTime implements Comparable<WaitTime> {
        private long endTime;
        private final int index;

        public WaitTime(long endTime, int index) {
            this.endTime = endTime;
            this.index = index;
        }

        public void addTime(long time) {
            this.endTime += time;
        }

        public int getIndex() {
            return index;
        }

        public long getEndTime() {
            return this.endTime;
        }

        @Override
        public int compareTo(WaitTime o) {
            if (this.endTime > o.endTime) return 1;
            else if (this.endTime < o.endTime) return -1;
            return  0;
        }
    }
}
```


- 시간 초과

### 두번째 시도

```java
static class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = times[0];
        long end = n * (long) times[times.length - 1];

        while (start <= end) {
            long mid = (start + end) / 2;

            long passPersonCount = 0;
            for (int time : times) {
                passPersonCount += (mid / time);
            }

            if (passPersonCount >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
```

- 이분 탐색으로 풀어야한다.
- 타입에 주의해야한다. long이 아니면 예외 처리됨 (시간초과로 나옴)
- 첫번째시도는 `(Log2N * N)`이라면 해당 시간 복잡도는 `Log2N`
