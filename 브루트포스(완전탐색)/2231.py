'''
입력값 n의 생성자 구하기
n부터 밑으로 내려가면서 방문해서 생성자를 찾는게 빠르다.
n의 자리수를 len(n)으로 구해서
한자리당 나올 수 있는 0 ~ 9, 즉 9개의 숫자가 나올수 있다고 가정.
n-1번째 ~ n - { len(n) * 9 } 번째까지에서 생성자가 없는 경우 존재 하지 않음.
** 가장 작은 생성자를 구하는 것이므로 n - { len(n) * 9 } 번째부터 차례로 방문해준다.
'''

n = int(input())
p_num = 0
for i in range(1, n+1):
    l = list(map(int, str(i)))
    s_num = i + sum(l)
    if s_num == n:
        p_num = i
        break
print(p_num)


'''     내가 푼 알고리즘       '''
def f(N):
    for x in range(int(N)-len(N)*9 , int(N)):
        if x > 0:
            tmp = list(map(int, str(x)))
            if x + sum(tmp) == int(N):
                return x
    return 0

print(f(input()))
'''     시간이 훨씬 절약됐다!        '''