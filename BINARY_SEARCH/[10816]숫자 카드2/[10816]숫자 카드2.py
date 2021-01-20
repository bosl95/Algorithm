from collections import Counter
import sys
input=sys.stdin.readline


n = int(input())
arr = list(map(int, input().split()))
m = int(input())
brr = list(map(int, input().split()))
arr = Counter(arr)

for c in brr:
    print(arr[c], end=' ')