import sys
input=sys.stdin.readline

# def solution(n, s, arr):
#     ans = 0
#     ch = 0
#     for i in range(1, 2 ** n):
#         tmp = i
#         tot = 0
#         for j in range(n):
#             if tmp % 2 == 1: tot += arr[j]
#             tmp //= 2
#             print(ch);ch+=1
#         if tot == s:
#             ans += 1
#     return ans


def solution2(arr, s):
    x = [0]
    ch = 0
    for i in arr:
        tmp = []
        for b in x:
            tmp.append(i + b)
            print(ch); ch+=1
        x += tmp
    return x.count(s)-(s==0)

N, S = map(int, input().split())
arr = list(map(int, input().split()))
print(solution2(arr, S))


