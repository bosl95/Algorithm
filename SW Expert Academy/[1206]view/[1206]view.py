def solution(n, arr):
    result = 0

    for i in range(n):
        if i < 2 and i > n-3 or arr[i] ==0:
            continue
        a = max(arr[i-2], arr[i-1], arr[i+1], arr[i+2])
        if arr[i] > a:
            result += (arr[i]-a)

    return result

T = 10
for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    print("#{} {}".format(test_case, solution(n, arr)))