from itertools import combinations
N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = 0
# for i in range(N):
#     for j in range(i+1,N):
#         for k in range(j+1, N):
#             if arr[i] + arr[j] + arr[k] > M:
#                 continue
#             else:
#                 result = max(result, arr[i] + arr[j] + arr[k])
# print(result)
# 전부 방문하기.

for c in combinations(arr, 3):
    tmp = sum(c)
    if result<tmp<=M:
        result = tmp # max로 하는게 훨씬 오래걸림
print(result)