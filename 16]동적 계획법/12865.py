# n, k = map(int, input().split())
# stuff = [ list(map(int, input().split())) for _ in range(n) ]
# dp = []
# for sw, sv in stuff:
#     # 무게 합 < k 이면 추가
#     tmp = []
#     for i in range(len(dp)):
#         if dp[i][0] + sw <= k:
#             tmp.append([dp[i][0]+sw, dp[i][1]+sv])
#     dp.extend(tmp)
#     # 그냥 추가
#     dp.append([sw, sv])
# dp.sort(key=lambda x:x[1])
# print(dp[-1][1])
''' 시간초과 '''

n, k = map(int, input().split())
stuff = [tuple(map(int, input().split())) for _ in range(n) ]
w = [0 for _ in range(k+1)]

for i in range(n):
