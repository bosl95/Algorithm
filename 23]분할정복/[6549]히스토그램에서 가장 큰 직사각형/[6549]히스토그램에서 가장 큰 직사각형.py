while True:
    N, *H=list(map(int, input().split()))
    if N == 0: break
    H.append(0)
    s=[]
    ans=0
    for i, h in enumerate(H):
        while s and H[s[-1]] > h:  # h보다 작은 값이 나올때까지 실행
            th = H[s.pop()]
            w = i - s[-1] - 1 if s else i
            # 스택이 비어있다 : 최소 높이의 인덱스라는 의미이므로 가로는 i
            # 아닌 경우는 i에서 s의 top인 인덱스를 빼준다.
            if ans < th * w: ans = th * w
        s.append(i)
    print(ans)