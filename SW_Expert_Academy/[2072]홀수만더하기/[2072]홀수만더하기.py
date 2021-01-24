def solution(arr):
    result = 0
    for a in arr:
        if a%2 == 1:
            result += a
    return result

T = int(input())

for test_case in range(1, T + 1):
    arr = list(map(int, input().split()))
    print("#{} {}".format(test_case, solution(arr)))