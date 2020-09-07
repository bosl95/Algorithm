import sys; input=sys.stdin.readline

def solution(n, time):
    cnt = 1
    time.sort(key=lambda x:(x[1], x[0]))
    end = time[0][1]
    for i in range(1, len(time)):
        if end <= time[i][0]:
            end = time[i][1]
            cnt += 1
    return cnt

n = int(input())
time = [list(map(int, input().split())) for _ in range(n)]
print(solution(n, time))
