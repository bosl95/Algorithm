import sys; input = sys.stdin.readline
from collections import deque
def AC(arr, x):
    f = 0; re =True
    arr =deque(list(' '.join(arr).split()))

    for xx in x:
        if xx=="R":
            if re:
                f = len(arr)-1
                re = False
            else:
                f=0
                re =True

        elif xx=="D":
            if arr:
                if re:
                    f+=1
                    arr.popleft()
                else:
                    f-=1
                    arr.pop()
            else:
                print("error")
                return
    if not re:
        arr.reverse()

    print('[', end='')
    print(','.join(arr), end=']\n')

case_n = int(input())
for _  in range(case_n):
    x = list(input())
    input()
    arr = list(input()[1:-2].split(','))
    AC(arr, x)

'''
18-23번째 줄에서 시간을 많이 잡아 먹었다.
그냥 pop을 써서 풀면 값의 이동시간이 대폭 상승하여 시간 초과가 발생하기 때문에
그리고 덱을 이용하여 시간을 단축시킬 수 있다.
오류가 나는 몇가지 경우들을 고려해줘야한다.
- 빈 배열을 받는 경우 R은 오류 없음, D는 오류 있음
+) 출력하는 부분이 좀 까탈스러웠다..
'''