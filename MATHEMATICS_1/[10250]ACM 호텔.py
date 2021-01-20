for i in range(int(input())):
    h, w, n = map(int, input().split())
    # a = n // h
    # b = n % h
    # if b == 0 : b = h; a -= 1
    # print("%d%02d"% (b,a+1))

    #숏코딩
    print((n-1)%h*100 + (n-1)//h + 101)