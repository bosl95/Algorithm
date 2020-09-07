import sys
input = sys.stdin.readline

def solution(n, A):
    left = [0] * n
    right = [0] * n
    res = -1

    for i in range(n):
        l, r = 1, 1
        for j in range(i):
            if A[j] < A[i] and l < left[j] + 1:
                l = left[j] + 1
            if A[n-1-j] < A[n-1-i] and r < right[n-1-j] + 1:
                r = right[n-1-j] + 1
        left[i] = l
        right[n-1-i] = r

    for i in range(n):
        if res < left[i] + right[i]:
            res = left[i] + right[i] - 1

    return res

n = int(input().strip())
A = list(map(int, input().strip().split()))
print(solution(n, A))