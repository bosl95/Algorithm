print('수열을 입력해주세요 (공백 포함)')
arr = list(map(int, input().split()))
n = len(arr)
dp = [1]*n
for i in range(n):
    for j in range(i):
        if arr[i] > arr[j] and dp[i] < dp[j]+1:
            dp[i] = dp[j]+1
print(dp)
