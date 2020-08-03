import sys
input = sys.stdin.readline

def solution(n, info):
    result = [1] * n
    for i in range(n):
        for j in range(i+1, n):
            if info[i][0] > info[j][0] and info[i][1] > info[j][1]:
                result[j] += 1
            elif info[j][0] > info[i][0] and info[j][1] > info[i][1]:
                result[i] += 1
    return result

n = int(input())
info = [list(map(int, input().split()))  for _ in range(n)]
print(*solution(n, info))