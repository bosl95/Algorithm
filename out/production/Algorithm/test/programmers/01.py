from collections import deque


def solution(n):
    ans = 0
    A = []

    while n >= 3:
        A.append(n % 3)
        n = n // 3
    A.append(n)

    i = 0
    while A:
        x = A.pop()
        ans += ((3 ** i) * x)
        i += 1

    return ans

print(solution(125))