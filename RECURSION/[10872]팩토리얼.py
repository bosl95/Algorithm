# result=1
# for i in range(1,int(input())+1):result*=i;
# print(result)

r=i=1;exec('r*=i;i+=1;'*int(input()));print(r)