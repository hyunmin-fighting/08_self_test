package step8_03_atm3.copy1;

public class User1 {
	
	String id;
	String password;
	Account1[] accList;
	int accCount;
	
	User1(){}
	User1(String id, String password){
		this.id = id;
		this.password = password;
	}
	User1(String id, String password, Account1[] accList, int accCount){
		this.id = id;
		this.password = password;
		this.accList = accList;
		this.accCount = accCount;
	}


	void printOneUserAllAccounts() {
		if(accCount == 0) {
			System.out.println(id + "\t" + password + "\t계좌를 개설해주세요." );
		}
		else if(accCount > 0) {
			System.out.println(id + "\t" + password + "\t");
			for (int i = 0; i < accCount; i++) {
				System.out.println(accList[i].number + "/" + accList[i].money);
			}
		}
		System.out.println();
	}
	
}
