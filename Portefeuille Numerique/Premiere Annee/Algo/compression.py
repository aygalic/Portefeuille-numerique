def test():
    donnee=[1,1,0,0,0,1,1,1,0,1,1,1]
    compression=[0 for i in range(12)]
    j=0
    premier=donnee[0]
    courant=premier
    for i in range (11):
        if(donnee[i]==courant):
            compression[j]=compression[j]+1
        else:
            j=j+1
            courant=donnee[i]
            compression[j]=1
    print(compression)
    
def decomp(donnee, preier):
    total = 0
    j=0
    courant=premier
    l=len(donnee)
    for i in range (l):
        total = total + donnee[i]
        i=i+1
    decomp=[0 for i in range(total)]
    for i in range (total):
        while donnee[i]!=0:
            decomp[j]=courant
            donnee[i]=donnee[i]-1
            j=j+1
        if courant == 1:
            courant = 0
        elif courant ==0:
            courant = 1
        i=i+1
    print(decomp)
