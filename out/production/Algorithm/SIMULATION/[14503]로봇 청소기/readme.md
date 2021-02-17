# [[14504]로봇 청소기](https://www.acmicpc.net/problem/14503)

## Simulation을 이용한 풀이

<image src='https://lh4.googleusercontent.com/tynkpOz0Y8AB4JkUC5d_t8qSccsiVIGmwKPzz2tanthFK89s6TzWOE75ntFt0zxxk6cvN8RMzQPpeAk1BKiziSQh-ozRhb9Z4TrGFpK659fVT2D0Fn7qyXtgRxbSLuovMB74xTUq' width='70%'>

<image src='https://lh3.googleusercontent.com/b_WD4CvhyYDXOIZWcXyi6JQcGccgeXGTpD3K5-jxvyAE8ATayg0hQV6bbknpA-jYSPEr0XPFAQG6twyM4KBbajpB7wnGhDOsuCf5ZKfX_HdfpK3VUYm57SkjAgqznyWlA7FYWgxl' width='70%'>

<br>

## 주의할 점 

    if place[mx][my]==0 and visit[mx][my]==0:
        visit[mx][my]=1
        d__ = 3 if d__==0 else d__-1
        stack.append((mx, my, d__))
        ans += 1
        break

> 로봇 청소기가 회전하여 이동하는 경우, 왼쪽으로 이동했기 때문에 <br>
> 이동하는 방향에서 오른쪽(d__-1)이 로봇청소기가 바라보는 방향이 된다.