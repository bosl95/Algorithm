import sys
input=sys.stdin.readline

def solution(n, k, coin):
    coin.sort()
    dp = [0] * (k+1)
    dp[0] = 1
    for c in coin:
        for i in range(c, k+1):
            dp[i] += dp[i-c]
    return dp[k]

N, K = map(int, input().split())
Coin = [int(input()) for _ in range(N)]
print(solution(N, K, Coin))