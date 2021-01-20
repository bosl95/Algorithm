import sys
input = sys.stdin.readline

def search(idx, a, n):
    low, high, x = 0, n-1, a[idx]
    while True:
        _x = a[low] + a[high]
        if low == idx or _x < x:
            low += 1
        elif high == idx or _x > x:
            high -= 1
        elif _x == x: return True

        if low >= high: return False

def solution(N, a):
    ans = 0
    a.sort()

    for i in range(N):
        if search(i, a, n):
            ans += 1
    return ans

n = int(input())
A = list(map(int, input().split()))
print(solution(n, A))