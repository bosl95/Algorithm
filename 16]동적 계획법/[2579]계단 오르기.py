# stair = []
# n = int(input())
# for _ in range(n):
#     stair.append(int(input()))
# dp = [] # index 칸까지 올라가는 데 최댓값
# dp.append(stair[0])
# dp.append(stair[0] + stair[1])
# dp.append(max(stair[0]+stair[2], stair[1]+stair[2])) # 3번째 계단까지의 최댓값
#
# for i in range(3, n):
#     dp.append(max(stair[i] + stair[i-1] + dp[i-3], stair[i] + dp[i-2]))
# print(dp[-1])

'''
dp를 어떤식으로 활용하는 지가 관건
dp[i] = i까지 도달하는 경우의 최대값
'''
n = int(input())
stair = [int(input()) for _ in range(n)]
if n==1: print(stair[n-1])
elif n==2: print(sum(stair))
else:
    dp = [stair[0], stair[0]+stair[1], max(stair[1]+stair[2], stair[0]+stair[2])]

    for i in range(3, n):
        dp.append(max(stair[i]+stair[i-1]+dp[i-3], stair[i]+dp[i-2]))
    print(dp[-1])