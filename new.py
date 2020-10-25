def solution(str1, str2):
    A, B = [], []
    p1, p2 = 0, 0
    for i in range(len(str1)-1):
        x, y = ord(str1[i]), ord(str1[i+1])
        if (64 < x < 91 or 96 < x < 123) and (64 < y < 91 or 96 < y < 123):
            A.append(str1[i:i+2].lower())

    for i in range(len(str2)-1):
        x, y = ord(str2[i]), ord(str2[i+1])
        if (64 < x < 91 or 96 < x < 123) and (64 < y < 91 or 96 < y < 123):
            B.append(str2[i:i+2].lower())

    for a in A:
        if a in B:
            B.remove(a)
            p1+=1
        p2+=1
    p2+=len(B)

    if p1==0 and p2==0: return 65536
    return int((p1/p2)*65536)

print(solution("aa1+aa2", "AAAA12"))