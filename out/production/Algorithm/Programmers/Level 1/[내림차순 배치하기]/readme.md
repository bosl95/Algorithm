# [내림차순 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12917?language=python3)

## String을 이용한 풀이

- 대문자와 소문자를 구분해서 내림차 정렬하는 문제였다.
- 대문자 소문자가 섞인 문자열을 sort하면
    - 대문자 우선 정렬
    - 소문자 정렬 순으로 이루어 진다.
- 이것을 알고 있다면 1줄로 간단히 풀 수 있다.

<br>

##  다른 사람의 풀이

    def solution(s):
        return ''.join(sorted(s, reverse=True))
