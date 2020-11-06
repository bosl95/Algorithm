# [내 마음대로 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/12915) 

## String을 이용한 문제 풀이

1. n번째 글자의 ord 값을 key 값으로 가지는 dict에 strings[i]를 추가한다.
2. 1번이 끝나면 dict의 key 값을 정렬하여 순차적으로 answer 배열에 넣어준다.
3. 이 때 dict 값이 여러개라면 (= n번째 글자가 같다) 일단 tmp에 문자열들을 넣어주고 sort하여(사전순) answer 배열에 순서대로 삽입한다.

<br>

## 다른 사람의 풀이

    def solution(strings, n):
        return sorted(sorted(strings), key=lambda x:x[n])
        
- n번째 글자가 같은 경우엔 사전 순이 되기 때문에, 처음부터 정렬된 strings를 n번째 글자를 기준으로 정렬한다.