package makihyppy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tuomaristo {

	private Random random;
	
	public Tuomaristo(){
		this.random = new Random();
	}
	
	public List<Integer> annaPisteet(){
		List<Integer> tuomaripisteet = new ArrayList<Integer>();
		
		for(int i = 0; i < 5; i++){
			tuomaripisteet.add(random.nextInt(11) + 10);
		}
		
		Collections.sort(tuomaripisteet);
		
		return tuomaripisteet;
	}
	
}
