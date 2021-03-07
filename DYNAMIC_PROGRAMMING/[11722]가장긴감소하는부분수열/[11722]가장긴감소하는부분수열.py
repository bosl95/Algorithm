def solution(n, a):
    dp = [1] * n

    for i in range(n):
        for j in range(i):
            if a[j] > a[i] and dp[j]+1 > dp[i]:
                dp[i] = dp[j]+1
    return max(dp)

N = int(input())
A = list(map(int, input().split()))
print(solution(N, A))