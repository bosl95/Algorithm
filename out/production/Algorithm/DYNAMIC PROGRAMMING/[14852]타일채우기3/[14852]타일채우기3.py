import sys
input=sys.stdin.readline

def solution(n):
    a, b, c = 1, 2, 7
    dp2 = a
    if n==0: return a
    if n==1: return b
    if n==2: return c

    for i in range(3, n+1):
        a, b, c = b, c, (2*c+3*b+2*dp2) % 1000000007
        dp2 = (dp2 + a) % 1000000007

    return c % 1000000007

N = int(input())
print(solution(N))