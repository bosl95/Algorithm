# 등수 = 총 인원 - 재낀 사람수
import sys
arr = []
for _ in range(int(input())):
    x,y = sys.stdin.readline().split()
    arr.append([x,y])

for i in arr:
    r = 1
    for j in arr:
        if i[0] < j[0] and i[1] < j[1] :
            r += 1
    print(r, end=" ")
# 또 여기 뒤부분을 못만ㄷ ㅡㅁ... 머리 안굴러ㄴ간다 진자루..