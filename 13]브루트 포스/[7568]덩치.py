# 등수 = 총 인원 - 재낀 사람수
import sys
arr = []
for _ in range(int(input())):
    x,y = sys.stdin.readline().split()
    arr.append([x,y])

for i in arr:
    r = 1
    for j in arr:
        if i[0] < j[0] and i[1] < j[1] :
            r += 1
    print(r, end=" ")


'''     내가 푼 알고리즘       '''
import sys
arr = []
n = int(sys.stdin.readline())
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))
rank = [1] * n
for i in range(n):
    for j in range(n):
        if arr[i][1] > arr[j][1] and arr[i][0] > arr[j][0]:
            rank[j] += 1
print(*rank)

