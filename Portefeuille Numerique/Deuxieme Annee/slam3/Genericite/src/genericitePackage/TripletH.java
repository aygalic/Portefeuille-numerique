package genericitePackage;

public class TripletH	<A,B,C> {
    private A a; 
    private B b;
    private C c;
 public TripletH(A a, B b, C c){ 
	  this.a=a ; 
	  this.b=b ; 
	  this.c=c;
 } 
 public A getPremier(){
	  return this.a;
 }
 public B getSecond(){
	  return this.b;
 }
 public C getTroiseme(){
	  return this.c;
 }
 public void affiche(){
	  System.out.println(a.toString()+b.toString()+c.toString());
 }
  
}
