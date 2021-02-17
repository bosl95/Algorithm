import sys
input=sys.stdin.readline


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def solution(n, p):
    h, cnt, ans = [], 0, 0

    for i in range(3):
        p.sort(key=lambda x:x[i])
        for j in range(n-1):
            h.append((abs(p[j][i]-p[j+1][i]), p[j][3], p[j+1][3]))

    h.sort()

    for hh in h:
        c, u, v = hh
        r_u, r_v = find(u), find(v)
        if r_u != r_v:
            parent[r_u] = r_v
            ans += c
            cnt += 1
            if cnt == n-1:
                break

    return ans


n = int(input())
parent = [i for i in range(n)]
planet = [list(map(int, input().split()))+[i] for i  in range(n)]
print(solution(n, planet))