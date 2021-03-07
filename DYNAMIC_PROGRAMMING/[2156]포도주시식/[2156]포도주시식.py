import sys
input = sys.stdin.readline

def solution(n, w):
    if n<=2:
        return sum(w)

    dp = [w[0], w[0]+w[1]] + [0] * (n-2)
    dp[2] = max(dp[1], w[0]+w[2], w[1]+w[2])

    for k in range(3, n):
        dp[k] = max(w[k]+dp[k-2], w[k]+w[k-1]+dp[k-3], dp[k-1])

    return dp[n-1]

n = int(input().strip())
wine = [int(input().strip()) for _ in range(n)]
print(solution(n, wine))