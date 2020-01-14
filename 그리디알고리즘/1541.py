n = input().split('-')
for i in range(len(n)):
    n[i] = list(map(int, n[i].split('+')))
    n[i] = sum(n[i])
print(n[0] - sum(n[1:]))
# 55-50+40-10