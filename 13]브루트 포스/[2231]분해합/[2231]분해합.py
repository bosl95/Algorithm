import sys
input = sys.stdin.readline

def solution(n):
    for x in range(int(n)-len(n)*9, int(n)):
        if x > 0:
            a = list(map(int, str(x)))
            if x + sum(a) == int(n):
                return x
    return 0


print(solution(input()))