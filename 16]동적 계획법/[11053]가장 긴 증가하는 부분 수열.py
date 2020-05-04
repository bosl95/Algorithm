# import sys
# n = int(sys.stdin.readline().strip())
# arr = list(map(int, sys.stdin.readline().strip().split()))
# dp = [0]*n
#
# for i in range(n):
#     for j in range(i):
#         if arr[j] < arr[i] and dp[i] <= dp[j]:
#             dp[i] = dp[j]
#     dp[i] += 1
# print(max(dp))

import sys
n = int(sys.stdin.readline().strip())
a = list(map(int, sys.stdin.readline().strip().split()))
num = [0] * 1001
for i in range(n):
    num[a[i]] = max(num[:a[i]])+1
print(max(num))