def soltuion(t, arr):
    dp = [1, 2, 4]

    for i in range(3, 11):
        dp.append(dp[i-1]+dp[i-2]+dp[i-3])

    for a in arr:
        print(dp[a-1])

T = int(input())
Arr = [int(input()) for _ in range(T)]
soltuion(T, Arr)