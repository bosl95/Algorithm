def solution(n):
    dp = [0] + [1] * 9

    for _ in range(1, n):
        tmp = [0] * 10
        for j in range(10):
            if j == 0:
                tmp[j] = dp[1]
            elif j == 9:
                tmp[j] = dp[8]
            else:
                tmp[j] = (dp[j-1] + dp[j+1]) % 1000000000
        dp = tmp
    return sum(dp) % 1000000000

n = int(input())
print(solution(n))