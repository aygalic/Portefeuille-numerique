def palindrome(mot):
    l=len(mot)
    print(l)
    pal=True
    for i in range(l//2):
        if(mot[i]!=mot[l-i-1]):
            pal=False
    return pal
    
