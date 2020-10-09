import sys
input=sys.stdin.readline

def solution(N, a):
    low, high = 0, N-1
    approx = a[low]+a[high]   # approx : 근사치

    while True:
        x = a[low]+a[high]
        if x>0:
            high -= 1
        elif x<0:
            low += 1
        else:
            return 0

        if abs(approx) > abs(x):
            approx = x

        if low >= high: return approx

n = int(input())
A = list(map(int, input().split()))
print(solution(n, A))