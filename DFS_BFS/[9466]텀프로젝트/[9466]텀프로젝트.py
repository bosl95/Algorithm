import sys; input=sys.stdin.readline
def solution(n, stu):
    end = []
    cnt = 0
    for i in range(n):
        stack = [i]
        visit = []

        while True:
            x = stack.pop()
            print(x)
            if stu[x-1] in end or x in end:
                break

            if x not in visit:
                visit.append(x)
                stack.append(stu[x-1])
            else:
                end += visit
                while True:
                    cnt += 1
                    if visit.pop()==x:
                        break



    return n-cnt

n = int(input())
for _ in range(n):
    m = int(input())
    tmp = list(map(int, input().split()))
    print(solution(m, tmp))