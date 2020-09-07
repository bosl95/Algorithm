def solution(n, arr):
    dp = [arr[0]] + [0] * (n-1)

    for i in range(1, n):
        dp[i] = max(dp[i-1]+arr[i], arr[i])

    return max(dp)

n = int(input())
arr = list(map(int, input().split()))
print(solution(n, arr))