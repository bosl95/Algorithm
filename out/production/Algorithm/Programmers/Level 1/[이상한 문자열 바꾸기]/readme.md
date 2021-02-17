# [이상한 문자열 바꾸기](https://programmers.co.kr/learn/courses/30/lessons/12930#)

## String을 이용한 풀이

- 짝수는 대문자, 홀수는 소문자 임에 주의하자 (문제를 잘못 읽어 짝수 대문자만 검사했다.)

<br>

## 다른 사람의 풀이

- 기능과 코드 자체는 다 똑같지만 한줄로 압축하여 표현한 코드이다.

        def toWeirdCase(s):
            return ' '.join([''.join([c.upper() if i % 2 == 0 else c.lower() for i, c in enumerate(w)]) for w in s.split()])