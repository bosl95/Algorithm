# 길이가 n인 수열 S와 자연수 m, k가 주어질 때 길이가 m인 S의 연속 부분 수열 중 합이 k인 수열의 수를 구하라.


S = list(map(int, input('수열 S를 입력하시오 : ').split()))
m, k = map(int, input().split())
ans = 0
res = [0]*len(S)
result = sum(S[:4])
res[m-1] = result
if res[m-1] == k: ans += 1
s, e = 0, m-1

for i in range(4, len(S)):
    e += 1
    result += (-S[s]+S[e])
    s += 1
    res[i] = result
    if res[i] == k: ans += 1
    
print(res, ans)

# 1 3 4 2 1 1 7 8 9 1 2 4 3 2 8 6 4
# 4 8