import sys
input = sys.stdin.readline

def solution(n, s):
    if n <= 2:
        return sum(s)
    elif n == 3:
        return max(s[1] + s[2], s[0] + s[2])
    dp = [0] * n
    dp[0], dp[1], dp[2] = s[0], s[0]+s[1], max(s[1]+s[2], s[0]+s[2])

    for i in range(3, n):
        dp[i] = s[i]+ max(s[i-1]+dp[i-3], dp[i-2])

    return dp[n-1]

n = int(input())
stairs = [int(input().strip()) for _ in range(n)]
print(solution(n, stairs))