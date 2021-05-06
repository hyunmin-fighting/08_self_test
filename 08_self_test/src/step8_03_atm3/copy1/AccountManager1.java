package step8_03_atm3.copy1;


public class AccountManager1 {

	private AccountManager1() {}
	private static AccountManager1 instance = new AccountManager1();
	static AccountManager1 getInstance() {
		return instance;
	}
	
	UserManager1 userManager = UserManager1.getInstance();


	void createAccount() {}
	
	
//	int showAccList(String msg) {}
	
	
	void income() {}
	
	
	void outcome() {}
	
	
//	int checkAcc(String transAccount) {}
	
	
//	int getAccIndex(int transUserIndex, String transAccount) {}
	
	
	void transfer() {}
	
	
	void lookupAcc() {}

	
	void deleteAcc() {}
	
	
}
