# import sys;arr = []; n = int(sys.stdin.readline())
# for _ in range(n):
#     arr.append(int(sys.stdin.readline()))
# arr.sort(); answer=0
# for i in range(n):
#     tmp = arr[i]*(n-i)
#     answer = max(answer, tmp)
# print(answer)

# 짧은 코드
import sys
n = int(sys.stdin.readline())
arr = sorted([int(sys.stdin.readline()) for _ in range(n)])
a = 0
for i in range(n):
    a = max(a, arr[i]*(n-i))
print(a)