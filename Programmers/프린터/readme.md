# [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)

## 풀이

- 그냥 문제 그대로 풀면 통과한다.
- 다른 사람의 풀이를 보면 우선 순위를 한번 정렬하여 비교하는 방식으로 탐색 시간을 줄일 수도 있다.

```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        // 우선 순위를 정렬한다.
        Arrays.sort(priorities);
        int size = priorities.length-1;
        

        while(!que.isEmpty()){
            Integer i = que.poll();
            // 우선 순위를 비교한다. answer 만큼 빼는 것은 pop된 경우 없어진 만큼 빼줘야하기 때문
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}

```