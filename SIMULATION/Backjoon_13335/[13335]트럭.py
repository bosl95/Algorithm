import sys
input=sys.stdin.readline

def solution(n, w, l, truck):
    i, bw, time = 0, 0, 0
    bridge, chk = [], [0] * n

    while True:
        t = []; time += 1
        for b in bridge:
            if chk[b] == w:
                bw -= truck[b]
                continue
            chk[b] += 1
            t.append(b)
        bridge = t
        if i < n and bw + truck[i] <= l:
            bw += truck[i]
            bridge.append(i)
            chk[i] = 1
            i += 1
        if not bridge: break
    return time

n, w, L = map(int, input().split())
A = list(map(int, input().split()))
print(solution(n, w, L, A))