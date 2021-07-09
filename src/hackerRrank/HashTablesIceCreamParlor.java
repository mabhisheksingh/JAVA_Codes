package hackerRrank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class HashTablesIceCreamParlor {

	public static void whatFlavors(List<Integer> cost, int money) {
		//cost : 2243
		//money : 5
		System.out.println("COST : "+ cost + " Money "+ money);
		TreeMap<Integer, String> hash = new TreeMap<Integer, String>();
		for(int i=0;i<cost.size();i++) {
			if(hash.containsKey( cost.get( i ))  ) {
				String tempvalue = hash.get( cost.get( i ) ) +","+ (i +1); 
				hash.replace(cost.get(i) , tempvalue);
				
			}else {
				hash.put(cost.get(i),  String.valueOf(i+1 ) );
			}
			
		}
		
		
		for (Integer integer : hash.keySet()) {
			System.out.println("Key : " + integer +" Index : "+hash.get(integer));
		}
		String firstIndex = "";
		String secondIndex = "";
		
		for (Integer integer : hash.keySet()) {
			//System.out.println("Key : " + integer +" Index : "+hash.get(integer));
			if(integer < money) {
				
				if( hash.get(integer ).contains(",") ) {
					firstIndex = hash.get( integer).split(",")[0];
				}else {
					firstIndex = hash.get( integer);
				}
				
				if( hash.containsKey( money - integer  )) {
					String []temps= null;
					if( hash.get(money - integer ).contains(",") ) {
						temps = hash.get( money - integer).split(",");
						secondIndex = temps[ temps.length-1 ];
					}else {
						secondIndex = hash.get(money - integer );
					}
					break;
				}
				
			}
		}
		
		//System.out.println("FI : "+ firstIndex + " SI : "+ secondIndex);
		if( Integer.valueOf(firstIndex) > Integer.valueOf(secondIndex))
			System.out.println(secondIndex + " "+ firstIndex);
		else
			System.out.println(firstIndex + " "+ secondIndex);

		
	}

	public static void main(String[] args) {
		List<Integer> cost = new ArrayList<Integer>();
		cost.add(7);
		cost.add(2);
		cost.add(5);
		cost.add(4);
		cost.add(11);
		int money = 12;
		whatFlavors(cost,money);
		
	}

}
