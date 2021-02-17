import sys; input=sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
v = int(input())   # search number
count = 0
print(arr.count(v))
# for a in arr:
#     if a==v:
#         count += 1
# print(count)
