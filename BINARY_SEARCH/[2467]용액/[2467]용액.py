import sys
input = sys.stdin.readline

def solution(N, Arr):
    low, high, m = 0, N-1, sys.maxsize
    ans = [0, N-1]
    while True:
        a, b = Arr[low], Arr[high]
        x = a + b
        if abs(x) < m :
            m = abs(x)
            ans = [Arr[low], Arr[high]]
        if x > 0:
            high -= 1
        elif x < 0:
            low += 1
        else:
            return [Arr[low], Arr[high]]

        if low >= high:
            return ans


n = int(input())
a = list(map(int, input().split()))
print(*solution(n, a))