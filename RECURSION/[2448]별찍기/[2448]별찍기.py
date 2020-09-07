triangle = ["  *  ", " * * ", "*****"]
n = int(input())
m= 3

while True:
    if n == m:
        break
    result=[]
    tmp = []
    for s in triangle:
        tmp.append(s+' '+s)    # 밑의 두 삼각형 합치기

    tmp2 = []
    for s in triangle:
        tmp2.append(' '*m+s+' '*m)  # 오른쪽으로 밀기

    result.append(tmp2+tmp)
    triangle = result[0]
    m *= 2

for s in triangle:
    print(s)

