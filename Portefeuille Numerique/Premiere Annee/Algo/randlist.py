import random
def tri():
    a=[random.randint(1,100) for i in range(20)]
    b=[0 for i in range(20)]
    c=0
    print(a)
    for i in range(20):
        for j in range(20):
            b[i]=a[100]
            if a[j]<b[i]:
                b[i]=a[j]
                c=j
        a[c]=100   
            
    print(b)
            
