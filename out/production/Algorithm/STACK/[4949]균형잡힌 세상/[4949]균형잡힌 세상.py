import sys; input=sys.stdin.readline
left = ["(", "["]; right=[")", "]"]
def f(line):
    s = []  # stack
    for w in line:
        if w in left:
            s.append(w)
        elif w in right:
            if not s: return "no"
            idx = 0 if w==")" else 1
            if s.pop()==left[idx]: continue
            else: return "no"
        elif w==".":
            return "no" if s else "yes"

while True:
    line = input()
    if line[0]==".":
        break
    print(f(line))
