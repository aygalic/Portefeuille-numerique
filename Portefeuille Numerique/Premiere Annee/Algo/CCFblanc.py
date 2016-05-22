import random 
def ccfBlanc():
    temp=0
    tab = [0 for i in range (12)]
    for i in range (12):
        tab[i]= random.randint(1,100)
    print(tab)
    N=len(tab)
    j=N - 1
    
    print(j)
    for i in range (len(tab)//2):
        temp = tab[i]
        tab[i]=tab[j]
        tab[j]=temp
        j=j-1
    print(tab)
