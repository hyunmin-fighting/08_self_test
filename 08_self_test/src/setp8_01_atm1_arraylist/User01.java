package setp8_01_atm1_arraylist;

import java.util.ArrayList;

public class User01 {

	String id = "";
	int accCount = 0;
	ArrayList<Account01> acc;
	
	void printAccount() {
		for (int i = 0; i < acc.size(); i++) {
			acc.get(i).printOwnAccount();
		}
	}
	
}
