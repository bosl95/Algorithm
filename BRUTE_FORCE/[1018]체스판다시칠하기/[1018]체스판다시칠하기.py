import sys
input = sys.stdin.readline

def solution(n, m, arr):
    wb = list('WBWBWBWB')
    bw = list('BWBWBWBW')

    chess = [wb, bw, wb, bw, wb, bw, wb, bw, wb]

    result = n*m

    for i in range(n-7):
        for j in range(m-7):
            wb = 0
            bw = 0
            for a in range(8):
                for b in range(8):
                    if arr[i+a][j+b] != chess[a][b]:
                        wb += 1
                    if arr[i+a][j+b] != chess[a+1][b]:
                        bw += 1
            result = min(result, wb, bw)
    return result

n, m = map(int, input().split())
arr = [list(input()) for _  in range(n)]
print(solution(n, m, arr))