import sys
a = list(map(int, sys.stdin.readline().strip().split()))
if a == sorted(a):
    print("ascending")
elif a == sorted(a, reverse=True):
    print("descending")
else:
    print("mixed")