import sys
input = sys.stdin.readline

def solution(n, arr):
    for i in range(1, n):
        for j in range(i+1):
            if j==0:
                arr[i][j] += arr[i-1][j]
            elif j==i:
                arr[i][j] += arr[i-1][j-1]
            else:
                arr[i][j] += max(arr[i-1][j-1], arr[i-1][j])
    return max(arr[n-1])

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
print(solution(n, arr))