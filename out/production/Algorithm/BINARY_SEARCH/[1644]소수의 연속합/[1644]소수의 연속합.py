def solution(n):
    ans = 0
    s, e, nsum = 0, 0, 0
    primlist = []
    arr = [False, False] + [True]*(n-1)

    for i in range(2, n+1):
        if arr[i]:
            primlist.append(i)
        for j in range(i*i, n+1, i):
            arr[j] = False

    while True:
        if nsum >= n:
            if nsum == n:
                ans += 1
            nsum -= primlist[s]
            s += 1
        elif e == len(primlist): break
        else:
            nsum += primlist[e]
            e += 1
    return ans

N = int(input())
print(solution(N))