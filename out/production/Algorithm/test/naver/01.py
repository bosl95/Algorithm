def solution(m, k):
    ans = ''
    i, n = 0, len(k)
    for mm in m:
        if i < n and k[i]==mm:
            i+=1
            continue
        ans += mm
    return ans

print(solution("kkaxbycyz", "abc"))
print(solution("acbbcdc", "abc"))