import sys
input = sys.stdin.readline

test_case = int(input())
for t in range(test_case):
    n, m = map(int, input().split())
    for _ in range(m):
        input()
    print(n-1)