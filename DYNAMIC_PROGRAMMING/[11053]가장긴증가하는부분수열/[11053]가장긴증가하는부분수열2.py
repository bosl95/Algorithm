def tp(N, arr):
    dp = [1]*N

    for i in range(N):
        for j in range(i):
            if arr[i] > arr[j] and dp[i] < 1+dp[j]:
                dp[i] = dp[j]+1
    return dp[N-1]

n = int(input())
nlist = list(map(int, input().split()))
print(tp(n, nlist))