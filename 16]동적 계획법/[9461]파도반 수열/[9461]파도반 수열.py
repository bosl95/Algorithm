def solution(x):
    global dp
    if x < 3 or dp[x]!= -1:
        return dp[x]

    dp[x] = solution(x-2) + solution(x-3)
    return dp[x]

t = int(input())
for _ in range(t):
    n = int(input())
    dp = [1, 1, 1] + [-1] * (n-1)
    print(solution(n-1))