def search(line):
    s = []; ans = 0
    for w in line:
        if w=="{":
            s.append(w)
        else:   # w=="}"
            if s:
                s.pop()
            else:
                s.append("{")
                ans += 1

    if s:   #
        ans += len(s)//2
    return ans

l = []
while True:
    line = input()
    if '-' in line:
        break
    l.append(search(line))

for i, v in enumerate(l):
    print("{}. {}".format((i+1), v))