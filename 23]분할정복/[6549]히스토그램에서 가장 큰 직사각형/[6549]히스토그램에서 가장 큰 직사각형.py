import sys;input = sys.stdin.readline
h_arr = []
while True:
    x = input()
    if x[0]=='0':
        break
    h_arr.append(list(map(int, x.split()))) # 입력

def DAC(arr):
    l = len(arr)
    if l == 1: return arr[0]
    else:
        m = min(arr)
        idx = arr.index(m)
        if idx==0:
            idx += 1
        return max(DAC(arr[:idx]), DAC(arr[idx:]), l*m)

for h in h_arr:
    print(DAC(h))
