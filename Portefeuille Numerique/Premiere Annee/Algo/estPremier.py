from math  import *
def estPremier(n):
    premier=True
    if n<=1:
        return -1
    if n==2 or n==3:
        return 1
    else:
        lim = sqrt(n)
        d=2
        p=1
    while d <= lim and premier == True:
        if n%d==0:
            premier = False
        else:
            d=d+p
            p=2
    if premier:
        return 1
    else:
        return -1
