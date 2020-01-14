import sys
N = int(sys.stdin.readline().strip())
arr = list(map(int, sys.stdin.readline().strip().split()))
inc = [1] * N
dec = [1] * N
res = [0] * N
# 증가 길이
for i in range(N):
    for j in range(i):
        if arr[i] > arr[j] and inc[i] < inc[j]+1:
            inc[i] = inc[j] + 1

# 감소 길이
for i in range(N-1, -1, -1):
    for j in range(i+1, N):
        if arr[i] > arr[j] and dec[j] + 1 > dec[i]:
            dec[i] = dec[j] + 1
    res[i] = inc[i] + dec[i] - 1
print(max(res))