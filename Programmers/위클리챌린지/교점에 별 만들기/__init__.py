def solution(line):
    answer = []
    INF = float('inf')

    n = len(line)
    minx, maxx, miny, maxy = INF, -INF, INF, -INF

    points = []
    for i in range(n):
        for j in range(i, n):
            if i == j: continue
            A, B, E, C, D, F = *line[i], *line[j]
            mo = A * D - B * C
            if mo == 0: continue
            x, y = (B * F - E * D) / mo, (E * C - A * F) / mo
            if not x.is_integer() or not y.is_integer(): continue
            x, y = int(x), int(y)
            minx, maxx, miny, maxy = min(minx, x), max(maxx, x), min(miny, y), max(maxy, y)
            points.append((x, y))
    answer = [['.' for _ in range(maxx - minx + 1)] for _ in range(maxy - miny + 1)]

    for x, y in points: answer[maxy - y][x - minx] = '*'
    return [''.join(ans) for ans in answer]