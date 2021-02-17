def solution(n):
    answer = 0
    t = []
    while n >= 3:
        n, x = n//3, n%3
        t.append(x)
    t.append(n)
    i = 0
    while t:
        answer += ((3 ** i) * t.pop())
        i += 1
    return answer

print(solution(125))