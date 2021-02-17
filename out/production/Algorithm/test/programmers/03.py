from collections import defaultdict

def f(n, edge, a, b):
    cnt = 1
    s = [a]
    check = [0] * n
    check[a] = 1
    while True:
        tmp = []
        while s:
            x = s.pop()
            for _x in edge[x]:
                if _x == b:
                    return cnt
                elif check[_x] ==1:
                    continue
                else:
                    tmp.append(_x)
                    check[_x] = 1
        if tmp: s = tmp; cnt += 1
        else: return 0

def median(a,b,c):
    if a>=b:
        if b>=c:
            return b
        elif c>=a:
            return a
        else :
            return c
    elif c>=b:
        return b
    elif c<=a:
        return a
    else:
        return c

def solution(n, edges):
    edge = defaultdict(list)

    for e in edges:
        edge[e[0]-1].append(e[1]-1)
        edge[e[1]-1].append(e[0]-1)

    tmp = [0] * (n+1)
    for i in range(n-1):
        for j in range(i+1, n):
            x = f(n, edge, i, j)
            tmp[x] += 1

    ans = [0, 0, 0]; k = 2
    for i in range(n, -1, -1):
        for j in range(tmp[i]):
            ans[k] = i
            k -= 1
            if k == -1:
                return median(ans[0], ans[1], ans[2])


    return median(ans[0], ans[1], ans[2])


# print(solution(3,[[1, 2]]))
print(solution(3,[[1, 2]]))