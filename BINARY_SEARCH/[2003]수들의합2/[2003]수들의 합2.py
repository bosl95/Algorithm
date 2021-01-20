N, M = map(int, input().split())
arr = list(map(int, input().split()))

ans = 0
s, e, res = 0, 0, 0

while True:
    if res >= M:
        res -= arr[s]
        s += 1
    elif e == N: break
    else:
        res += arr[e]
        e += 1
    if res == M: ans += 1

print(ans)
