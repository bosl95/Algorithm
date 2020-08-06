import sys
input = sys.stdin.readline

def solution(n, cost):
    dp = cost[0]

    for i in range(1, n):
        dp1 = cost[i][0] + min(dp[1], dp[2])
        dp2 = cost[i][1] + min(dp[0], dp[2])
        dp3 = cost[i][2] + min(dp[0], dp[1])
        dp = [dp1, dp2, dp3]
    return min(dp)


n = int(input())
cost = [list(map(int, input().split())) for _ in range(n) ]
print(solution(n, cost))