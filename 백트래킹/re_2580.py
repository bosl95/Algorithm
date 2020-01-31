# import sys;import numpy as np
# arr = np.array([sys.stdin.readline().split() for _ in range(9)])   # 가로
# arc = np.array([arr[:, i:i+1].reshape(9) for i in range(9)])
# m_m = np.array([arr[3*i:3*(i+1),3*j:3*(j+1)] for i in range(3) for j in range(3)])  # 3*3
# def check(row, column):
#     row=int(row);column=int(column);tmp=set(); mm_i=row*3+column
#     for i in ['1','2','3','4','5','6','7','8','9']:
#         if i not in arr[row] and i not in arc[column]:
#             tmp.add(i)
#     return tmp
# zero_num = np.count_nonzero(arr=='0')
# while(zero_num!=0):
#     for i in range(9):
#         for j in range(9):
#             if arr[i][j]=='0':
#                 s = check(i,j)  # s는 들어갈 수 있는 숫자들(set)
#                 if len(s)==1:
#                     arr[i][j]=s.pop()
#                     zero_num -= 1
# print(arr)
'''     돌아가긴 하는데 런타임 에러     '''
'''     백준에서는 numpy가 런타임 에러가 난다고 한다.... 으ㅏ어ㅏㅔ아아ㅏㅏ   '''

'''
a=b=c=[] 이런식으로 쓰면
다 연결 되서 오류남 ㅠㅠㅠ
'''
import sys;arr=[];zeros=[]
for i in range(9):
    arr.append(sys.stdin.readline().split())
    zeros += [(i, j) for j in range(9) if arr[i][j]=='0']

def check(i, j):
    tmp = ['1','2','3','4','5','6','7','8','9']
    for w in tmp.copy():
        if w in arr[i] or w in list(zip(*arr))[j]: tmp.remove(w)
        if w in list(zip(*arr[3*(i//3):3*(i//3+1)]))[3*(j//3):3*(j//3+1)]: tmp.remove(w)
    return tmp
def into(x):
    if x==len(zeros):
        for a in arr:
            print(*a)
        exit(0)
    else:
        (i,j)=zeros[x]
        n_list = check(i, j)
        for n in n_list:
            arr[i][j] = n
            into(x+1)
            arr[i][j] = 0   # 선택한 숫자가 조건 성립이 안될 경우 초기화
into(0)