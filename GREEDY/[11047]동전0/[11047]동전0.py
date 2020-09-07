import sys; input=sys.stdin.readline

def solution(n, k, coin):
    cnum = 0
    while k>0 and coin:
        c = coin.pop()
        chk = k//c
        if chk <= 0:
            continue
        else:
            cnum += chk
            k %= c
    return cnum

n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
print(solution(n, k, coin))