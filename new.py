def DFS(i, edge, visit):
    global answer
    s = 0
    for v in visit:
        if v: s += 1
    if answer < s: answer = s

    for x in edge[i]:
        if visit[x] < 2:
            visit[x] += 1
            DFS(x, edge, visit)
            visit[x] -= 1

answer = 0
def solution(t):
    tnum = len(t)
    edge = [[] for _ in range(tnum+1)]
    for i, v in t:
        edge[i].append(v)
        edge[v].append(i)

    for k in [i for i in range(tnum+1)]:
        visit = [0] * (tnum + 1)
        visit[k] += 1
        DFS(k, edge, visit)
    return answer


print(solution([[5,1],[2,5],[3,5],[3,6],[2,4],[4,0]]))
# print(solution([[2,5],[2,0],[3,2],[4,2],[2,1]]))