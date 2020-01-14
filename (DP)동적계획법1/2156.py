n = int(input())
#arr = [int(input()) for _ in range(n)]
# dp = []
# dp.append(arr[0])
# if n>1:
#     dp.append(arr[0]+ arr[1])
# if n>=3:
#     dp.append(max(arr[2]+arr[0], arr[2]+arr[1], dp[1]))
#     for i in range(3, n):
#         dp.append(max(arr[i]+arr[i-1]+dp[i-3], arr[i]+dp[i-2], dp[i-1]))
# print(dp[-1])
# 연속 3잔을 마시면 안되는 규칙
# 1 : 이번 포도주를 먹고 이전 포도주를 먹지 않는 경우
# 2 : 이번 포도주를 먹고 이전 포도주를 먹은 경우
# 3 : 이번 포도주를 먹지 않아야 하는 경우
# 계단 오르기와는 다른점 : 계단 오르기 경우 마지막 계단을 밟아야했음

# 숏코딩
dp = [0] * 3; pw=0
for i in range(n):
    w = int(input())
    dp.append(max(dp[-1], dp[-3]+w+pw, dp[-2]+w))
    pw = w
print(dp[-1])

# 숏코딩 보단 sys쓰면 훠어어얼씬 빨리 계산 가능함.