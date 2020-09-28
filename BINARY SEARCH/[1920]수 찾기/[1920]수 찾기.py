import sys
input=sys.stdin.readline

def solution(n, A, t):
    st, en = 0, n-1
    while st <= en:
        mid = (st+en)//2
        if A[mid] < t:
            st = mid + 1
        elif A[mid] > t:
            en = mid - 1
        else:
            return 1
    return 0

n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))
A.sort()
for b in B:
    print(solution(n, A, b))