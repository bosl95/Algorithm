import sys;n = int(sys.stdin.readline().strip())
result = list(map(int, sys.stdin.readline().split()))
print((sum(result)/max(result)*100)/n)