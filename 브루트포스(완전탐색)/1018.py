''' 내가 푼 알고리즘'''
import sys
B_start = [['B','W','B','W','B','W','B','W'],['W','B','W','B','W','B','W','B']] * 4
W_start = [['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B','W']] * 4
M, N = map(int, sys.stdin.readline().split())
b = []
for _ in range(M):
    b.append(list(sys.stdin.readline().strip()))

def check(arr):
    b=0;w=0
    for x in range(8):
        for y in range(8):
            if arr[x][y] != W_start[x][y]:
                w += 1
            if arr[x][y] != B_start[x][y]:
                b += 1
    return min(b, w)

result = 0
for i in range(M-7):
    for j in range(N-7):
        tmp_arr = []
        for b1 in b[i:i+8]:
            tmp_arr.append(b1[j:j+8])
        tmp = check(tmp_arr)
        if result > tmp or (i==0 and j==0):
            result = tmp
print(result)


'''
시작이 B일때와 W일때를 모두 비교해 
작은 값을 찾아주어야한다!!
'''