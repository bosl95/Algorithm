# n = int(input())
# p = []
# for i in range(n):
#     p.append(list(map(int, input().split())))
# for i in range(1, len(p)):
#     p[i][0] = min(p[i-1][1], p[i-1][2]) + p[i][0]
#     p[i][1] = min(p[i-1][0], p[i-1][2]) + p[i][1]
#     p[i][2] = min(p[i-1][0], p[i-1][1]) + p[i][2]
# print(min(p[n-1][0], p[n-1][1], p[n-1][2]))

# 옆집에만 중복 안되면 됨 그러니까 전꺼만 신경써서 최소값을 넣어주면됨
import sys
dp = [];
for _ in range(int(sys.stdin.readline())):
    dp.append(list(map(int, sys.stdin.readline().strip().split())))
for i in range(1, len(dp)):
    dp[i][0] = dp[i][0] + min(dp[i-1][1], dp[i-1][2])
    dp[i][1] = dp[i][1] + min(dp[i-1][0], dp[i-1][2])
    dp[i][2] = dp[i][2] + min(dp[i-1][0], dp[i-1][1])
print(min(dp[-1]))