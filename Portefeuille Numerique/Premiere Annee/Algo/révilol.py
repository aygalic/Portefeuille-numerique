from random import *
def test(liste):
    for i in range(30):
        j=randint(0,8)
        k=randint(0,8)
        temp=0
        temp=liste[j]
        liste[j]=liste[k]
        liste[k]=temp

    k=0
    liste5=[[0 for i in range(3)]for i in range(3)]
    for i in range(3):
        for j in range(3):
            liste5[i][j]=liste[k]
            k=k+1
    somme = [0 for i in range(3)]
    for i in range(3):
        for j in range(3):
            somme[i]=somme[i]+liste5[i][j]
    test=False
    for i in range(3):
        if somme[i]>=20:
            test=True
    if test:
        print("ta gagné lol")
    else:
        print("lol t nul")
    somme2=[0 for i in range(3)]
    for i in range(3):
        for j in range(3):
            somme2[i]=somme2[i]+liste5[j][i]
    test=False
    for i in range(3):
        if somme2[i]>=20:
            test=True
    if test:
        print("ta gagné lol")
    else:
        print("lol t nul")
    return liste5, somme, somme2
