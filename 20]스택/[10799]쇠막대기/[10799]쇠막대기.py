def f(line):
    bar = 0; res = 0
    pre = line[0]
    for w in line[1:]:
        if pre=="(":
            if w==")":
                res += bar
            elif w=="(":
                bar +=1
        elif pre==")" and w==")":
            res +=1
            bar -=1
        pre = w
    return res

print(f(list(input())))

