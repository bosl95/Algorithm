# [콜라츠 추측](https://programmers.co.kr/learn/courses/30/lessons/12943)

## 문제 풀이

- 문제의 로직 그대로 구현하면 되는 문제

<br>

## 다른 사람의 풀이

    def collatz(num):
        for i in range(500):
            num = num / 2 if num % 2 == 0 else num*3 + 1
            if num == 1:
                return i + 1
        return -1
   
- 500번까지이므로 반복문을 500번 돌리고,  num =1이 되는 경우  return 해주는 방법도 있다.
- 만약 반복문 안에서 return이 안되면 마지막에 -1을 리턴한다.