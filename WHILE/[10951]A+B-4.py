
while True:
    try:
        num = list(map(int, input().split()))
        print(sum(num))
    except:
        break

# (Python) input()은 EOFError를 발생시킵니다.
# (Python) sys.stdin.readline()은 빈 문자열을 반환합니다.
