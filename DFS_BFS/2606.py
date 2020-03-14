import sys;input=sys.stdin.readline
n = int(input());m = int(input())
a = [[0]*(n+1) for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    a[x][y]=1;a[y][x]=1

def virus(v):
    # for i in range(1, n+1):
    #     if a[v][i] == 1 and  i not in ch:
    #         ch.append(i)
    #         virus(i)
    # return len(ch)-1
    # DFS --> 틀렸다고 나오는데 모르겠다.

    '''     BFS로 2차 시도      '''
    visited = []
    queue = [v]

    while queue:
        n = queue.pop(0)
        if n not in visited:
            visited.append(n)
        for i, v in enumerate(a[n]):
            if i not in visited and v==1:
                queue.append(i)
    return len(visited)-1
print(virus(1))
'''
맞췄다.
BFS 정통 코드 참고했음.
'''