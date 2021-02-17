import sys
start = int(sys.stdin.readline().strip())
count = 1
temp = start
while True:
    last = temp//10 + temp%10
    temp = (temp%10)*10 + (last%10)
    if start == temp:
        break;
    count += 1
print(count)