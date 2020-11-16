def solution(n, a):
    left = [1]*n
    right = [1]*n
    ans = [0]*n

    for i in range(n):
        for j in range(i):
            if a[i] > a[j] and left[i] < left[j]+1:
                left[i] = left[j]+1
            if a[n-1-i] > a[n-i+j] and right[n-1-i] < right[n-i+j]+1:
                right[n-1-i] = right[n-i+j] + 1
        ans[i] = left[i]+right[i]
    return max(ans)-1

N = int(input())
A = list(map(int, input().split()))
print(solution(N, A))