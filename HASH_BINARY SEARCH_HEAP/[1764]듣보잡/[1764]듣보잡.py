import sys
input=sys.stdin.readline

def solution(a, b):
    c = a & b
    sorted(c)
    print(len(c))
    for _c in c:
        print(_c)

N, M = map(int, input().split())
A, B = set(), set()
for _ in range(N):
    A.add(input().strip())
for _ in range(M):
    B.add(input().strip())
solution(A, B)