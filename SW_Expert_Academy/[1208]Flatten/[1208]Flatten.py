def solution(cnt, a):
    n = len(a)
    while True:
        M, m = 0, 0
        for i in range(n):
            if a[M] < a[i]:
                M = i
            if a[m] > a[i]:
                m = i
        if a[M] - a[m] < 2 or cnt == 0:
            return a[M]-a[m]
        else:
            a[M] -= 1
            a[m] += 1
            cnt -= 1

for test_case in range(1, 11):
    c = int(input())
    arr = list(map(int, input().split()))
    print("#{} {}".format(test_case, solution(c, arr)))