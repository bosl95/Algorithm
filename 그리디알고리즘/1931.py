import sys;
N = int(sys.stdin.readline())
time = [[0]*2 for _ in range(N)]
for i in range(N):
    x, y = map(int, sys.stdin.readline().split())
    time[i][0] = x
    time[i][1] = y

time.sort(key= lambda x: (x[1], x[0]))
cnt = 1
end = time[0][1]
for i in range(1, N):
    if time[i][0] >= end:
        cnt += 1
        end = time[i][1]
print(cnt)

# tip : 종료시간을 먼저 sort 그다음 시작시간을 sort
# 중복 되는 것도 있으니까 같아도 +1 해줘야함
