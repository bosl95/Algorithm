for i in range(int(input())):
    a = input().split(' ')
    print(''.join([word*int(a[0]) for word in a[1]]))