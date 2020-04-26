import sys
for i in range(int(sys.stdin.readline())):
    count = 0
    a = list(map(int, sys.stdin.readline().strip().split()))
    m = a.pop(0);avg = sum(a)/m;a.sort(reverse=True)
    for j in a:
        if j <= avg:
            break
        count += 1
    print("%.3f%%"%(count/m*100))