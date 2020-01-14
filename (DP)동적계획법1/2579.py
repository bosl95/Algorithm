stair = []
n = int(input())
for _ in range(n):
    stair.append(int(input()))
dp = [] # index 칸까지 올라가는 데 최댓값
dp.append(stair[0])
dp.append(stair[0] + stair[1])
dp.append(max(stair[0]+stair[2], stair[1]+stair[2])) # 3번째 계단까지의 최댓값

for i in range(3, n):
    dp.append(max(stair[i] + stair[i-1] + dp[i-3], stair[i] + dp[i-2]))
print(dp[-1])

