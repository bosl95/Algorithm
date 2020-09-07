def solution(x):
    dp = [1, 2]
    if x < 2:
        return dp[x]

    for _ in range(1, x):
        dp[0], dp[1] = dp[1], (dp[0]+dp[1])%15746

    return dp[1]

n = int(input())
print(solution(n-1))
