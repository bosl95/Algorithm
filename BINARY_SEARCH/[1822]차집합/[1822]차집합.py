import sys
input =sys.stdin.readline

N, M = map(int, input().split())
a = set(map(int, input().strip().split(' ')))
b = set(map(int, input().strip().split(' ')))
a = list(a-b)
print(len(a))
a.sort()
print(*a)