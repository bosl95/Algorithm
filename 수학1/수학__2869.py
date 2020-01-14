a, b, v = map(int, input().split())
x = (v-b)/(a-b)
print(int(x) if x==int(x) else int(x)+1)