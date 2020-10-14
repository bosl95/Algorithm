def makeF(p):
    n = len(p)
    F = [0] * len(p)
    j = 0
    for i in range(1, n):
        if j>0 and p[i] != p[j]:    # p[i]와 p[j]가 같지 않으면 j = F[j-1]
            j = F[j-1]
        if p[i] == p[j]:
            F[i] = j+1              # p[i] == p[j]면 F[i] = j+1(j는 인덱스이므로)
            j += 1                  # j 한칸 이동
    return F

def kmp(s, p):
    ans = []
    fail = makeF(p)
    n, m, j = len(s), len(p), 0

    for i in range(n):
        if j>0 and s[i]!=p[j]:
            j = fail[j-1]
        if s[i] == p[j]:
            if j == m-1:
                ans.append(i-m+2)
                j = fail[j]
            else:
                j+=1

    print(len(ans))
    for a in ans:
        print(a, end=' ')


t = input()
p = input()
kmp(t, p)
