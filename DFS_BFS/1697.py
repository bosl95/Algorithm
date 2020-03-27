n, k = map(int, input().split())
visit =[0]*100001   # 주의
def search(nn):
    count = 0; arr =[nn]
    while True:
        tmp = []
        for a in arr:
            if a == k : return count    # 1 1과 같은 값에 주의하기
            for aa in [a+1, a-1, a*2]:
                if 0<=aa<=100000 and visit[aa]==0:  # 인덱스 주의
                    tmp.append(aa)
                    visit[aa]=1
        arr = tmp; count += 1
print(search(n))

'''
반례까 많은 문제였다.
+ 인덱스 주의하자
'''