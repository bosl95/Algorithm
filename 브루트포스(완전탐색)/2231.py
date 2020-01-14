n = int(input())
p_num = 0
for i in range(1, n+1):
    l = list(map(int, str(i)))
    s_num = i + sum(l)
    if s_num == n:
        p_num = i
        break
print(p_num)

#단순 무식하게 만들면 되긴 하는데 왜 나는 이게 안되닝 ㅠㅠㅠㅠ
