package step8_02_atm2.copy1;

import java.util.Random;
import java.util.Scanner;

public class AccountManager1 {

	//싱글톤
	private AccountManager1() {}
	private static AccountManager1 instance = new AccountManager1();
	static AccountManager1 getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager1 um = UserManager1.getInstance();

	// 계좌 생성 
	void createAcc(int identifier) {
		
		int currentAccCnt = um.userList[identifier].accCnt;
		
		if(currentAccCnt == 3) {
			System.out.println("[메시지] 계좌 개설은 3개까지만 가능합니다.");
			return;
		}
		
		um.userList[identifier].acc[currentAccCnt] = new Account1();
		
		String makeAccount = "";
		while(true) {
			makeAccount = Integer.toString(ran.nextInt(90001)+10000);
			if(!um.getCheckAcc(makeAccount)) {
				break;
			}
		}
		um.userList[identifier].acc[currentAccCnt].accNumber = makeAccount;
		um.userList[identifier].accCnt++;
		System.out.println("[메시지] " + um.userList[identifier].id + "님 계좌번호 " + makeAccount + "가 생성되었습니다.\n");	
	}	
	
	
	// 계좌 출력
	void printAcc(int identifier) {}
	
}
