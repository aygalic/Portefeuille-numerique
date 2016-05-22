from plusPetitPremier import *
def trouvePremier(n):
    i = 0
    compt = 1
    while i < n:
        compt = 1 + plusPetitPremier(compt)
        i=i+1
    return (compt-1)
