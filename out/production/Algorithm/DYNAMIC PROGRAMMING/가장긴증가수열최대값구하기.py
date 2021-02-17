print('수열을 입력해주세요 (공백 포함)')
arr = list(map(int, input().split()))
n = len(arr)
dp = arr.copy()
for i in range(n):
    for j in range(i):
        if arr[i] > arr[j] and dp[i] < dp[j]+arr[i]:
            dp[i] = dp[j]+arr[i]
print(dp)