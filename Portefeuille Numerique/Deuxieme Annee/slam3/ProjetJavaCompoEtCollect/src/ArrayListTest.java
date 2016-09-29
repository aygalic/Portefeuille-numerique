import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> test = new ArrayList(); 
		for(int i=0;i<15;i++){
			test.add(i);
		}
		int j = 0;
		for(Integer a:test){
			if(j%2==0){
				System.out.println(a);
			}
			j++;
		}
	}

}
