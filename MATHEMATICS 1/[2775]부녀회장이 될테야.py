for i in range(int(input())):
    k = int(input())
    n = int(input())
    arr = [j for j in range(1, n+1)]

    for i in range(k):
        for j in range(n-1):
            arr[j+1] = arr[j+1] + arr[j]
    print(arr[-1])