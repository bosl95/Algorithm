def solution(x):
    dp = [0] * 1000001
    dp[1], dp[2], dp[3] = 0, 1, 1

    for i in range(4, x+1):
        tmp = []
        if i%3 == 0:
            tmp.append(dp[i//3])
        if i%2 == 0:
            tmp.append(dp[i//2])
        tmp.append(dp[i-1])
        dp[i] = min(tmp) + 1

    return dp[x]

x = int(input())
print(solution(x))