# [3진법 뒤집기](https://programmers.co.kr/learn/courses/30/lessons/68935)

## 문제 풀이

- 로직대로 풀면 되는 문제 

1. 3진수로 만들어준다.
    
        while n >= 3:
            n, x = n//3, n%3
            t.append(x)
            t.append(n)
        t.append(n)
        
    - 나머지를 바로 배열 t에 넣어준다.
    - 마지막에 while문을 빠져 나온 n을 t에 넣어준다.
    
2. t 배열을 하나씩 pop 하면서 3<sup>i</sup>와 곱해 10진수로 만들어준다.