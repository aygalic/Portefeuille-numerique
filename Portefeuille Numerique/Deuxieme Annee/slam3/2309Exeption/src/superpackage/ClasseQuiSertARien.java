package superpackage;

import java.util.ArrayList;

public class ClasseQuiSertARien implements MonInterface {
	public  int nbPersonne(ArrayList<Personne> a) throws TropPetitException{
		int test = 0;
		for(Personne p : a){
			test++;
		}
		if(test==0){
			throw new TropPetitException();
		}
		return test;
	}
}
