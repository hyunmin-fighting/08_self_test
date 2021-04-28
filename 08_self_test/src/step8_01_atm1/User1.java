package step8_01_atm1;

public class User1 {

	String id = "";
	int accCount = 0;
	Account1[] acc;
	
	void printAccount() {
		for (int i = 0; i < accCount; i++) {
			acc[i].printOwnAccount();
		}
	}
	
}
