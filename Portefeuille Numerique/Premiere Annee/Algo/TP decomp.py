def decomp(compress, premier):
    l = len(compress)
    t=0
    for i in range (l):
        t = t + compress[i]
    decomp=[0 for i in range(t)]
    courant=premier
    j=0
    for i in range(l):
        while compress[i]!=0:
            decomp[j]=courant
            compress[i]=compress[i]-1
            j=j+1
        courant = 1 - courant
    print(decomp)







