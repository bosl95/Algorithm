import sys
input = sys.stdin.readline

def calc(a, b, stats):
    resA, resB = 0, 0
    for a1, b1 in zip(a, b):
        for a2, b2 in zip(a, b):
            if a1 != a2:
                resA += stats[a1][a2]
            if b1 != b2:
                resB += stats[b1][b2]

    return abs(resA-resB)

def dfs(i, team, n, stats):
    if i == n//2:
        global result
        team2 = [ t for t in range(n) if t not in team ]
        res = calc(team, team2, stats)
        if res < result:
            result = res
    else:
        for k in range(team[-1]+1, n):
            team.append(k)
            dfs(i+1, team, n, stats)
            team.pop()

def solution(n, stats):
    global result
    result = sys.maxsize
    dfs(1, [0], n, stats)
    return result

x = int(input())
print(solution(x, [list(map(int, input().split())) for _ in range(x)]))