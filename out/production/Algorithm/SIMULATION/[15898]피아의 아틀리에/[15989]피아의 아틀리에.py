import itertools, sys
from copy import deepcopy
input=sys.stdin.readline

def putin(sn, i, j, k, Arr):    # sn : 선택한 재료의 번호
    for a in range(4):
        for b in range(4):
            if k == 0: _a, _b = a, b
            elif k==1: _a, _b = 3-b, a
            elif k==2: _a, _b = 3-a, 3-b
            elif k==3: _a, _b = b, 3-a
            _num, _col = sNum[sn][_a][_b], sCol[sn][_a][_b]
            num, col = int(Arr[i+a][j+b][0]), Arr[i+a][j+b][1]
            _num += num
            if _num<0: _num = 0            # 품질 범위 체크
            elif _num>9: _num = 9
            if _col=='W':
                Arr[i+a][j+b] = str(_num)+col  # 재료가 W면 색은 안 변하지만 품질은 더해진다
            else:
                Arr[i+a][j+b] = str(_num)+_col
    return Arr

def DFS(src, x, _arr):
    if x == 3:
        dic = {'R':0, 'G':0, 'B':0, 'Y':0}
        for i in range(5):
            for j in range(5):
                if _arr[i][j][1] == 'W': continue
                dic[_arr[i][j][1]] += int(_arr[i][j][0])
        _ans = 7*dic['R']+5*dic['B']+3*dic['G']+2*dic['Y']
        global ans
        if ans < _ans:
            ans = _ans
        return

    for i in range(2):
        for j in range(2):
            for k in range(4):
                tmp_arr = deepcopy(_arr)
                DFS(src, x+1, putin(src[x], i, j, k, tmp_arr))

n = int(input())
sNum = [];sCol=[];
arr = [['0W']*5 for _ in range(5)]
ans = 0

for i in range(4):
    tmp = [list(map(int, input().split())) for _ in range(4)]
    sNum.append(tmp)
    tmp = []
    tmp = [input().split() for _ in range(4)]
    sCol.append(tmp)

for srcs in itertools.permutations([i for i in range(n)], 3):
    DFS(srcs, 0, arr)

print(ans)