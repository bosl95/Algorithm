n = int(input())
dp = [-1, 0, 1]
i=3
while True:
    dp.append((dp[i - 1] + dp[i - 2]) % 1000000)
    if i<=n:
        if (0, 1) == (dp[i - 1], dp[i]):
            i -= 2      # 초기화되는 지점의 인덱스
            break
        i += 1
    else:
        break
print(dp[n%i+1])    # index 주의!

