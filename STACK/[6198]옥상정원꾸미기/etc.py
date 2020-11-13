# 각 사람은 왼쪽 사람 중 자신보다 큰 사람중에 가장 오른쪽 사람을 본다. N 명의 사람이 각각 보는 사람의 번호 합을 구하여라.

person = list(map(int, input('서 있는 사람을 입력하시오 : ').split()))
n = len(person)

num = [0] * n
ans = 0

for i in range(n):
    if i == 0: continue
    for j in range(i-1, -1, -1):
        if person[j] > person[i]:
            num[i] = j+1
            ans += j+1
            break
print(num)
print(ans)