def solution(sizes):
    n = len(sizes)

    x, y = 0, 0
    for i in range(n):
        if sizes[i][0] > sizes[i][1]:
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0]

        if x < sizes[i][0]:
            x = sizes[i][0]
        if y < sizes[i][1]:
            y = sizes[i][1]

    return x * y
