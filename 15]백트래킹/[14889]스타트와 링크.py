import sys;from itertools import combinations
n = int(input()); arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

def combi(a):   # (2, 3, 4)가 주어지면 (2,3) (3,4) (2,4) 의 능력치 합을 리턴
    result = 0
    for c in list(combinations(a, 2)):
        result = result + arr[c[0]][c[1]] + arr[c[1]][c[0]]
    return result

com = list(combinations(list(range(n)), n//2))
m = sys.maxsize; i=0
# for s in [[com[i], com[-1-i]] for i in range(len(com)//2)]:
#     m = min(m, abs(combi(s[0]) - combi(s[1])))
while(i!=len(com)//2):
    m = min(m, abs(combi(com[i]) - combi(com[-1-i])))
    i += 1  # 위에 for문보다 메모리가 1만kb정도 적음
print(m)

