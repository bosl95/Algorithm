# import sys;arr = []; n = int(sys.stdin.readline())
# for _ in range(n):
#     arr.append(int(sys.stdin.readline()))
# arr.sort(); answer=0
# for i in range(n):
#     tmp = arr[i]*(n-i)
#     answer = max(answer, tmp)
# print(answer)
# 드디어 내가 풀었어 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ퓨퓨ㅠㅠㅠ

# 짧게 써보자!
import sys
n = int(sys.stdin.readline())
arr = sorted([int(sys.stdin.readline()) for _ in range(n)])
a = 0
for i in range(n):
    a = max(a, arr[i]*(n-i))
print(a)