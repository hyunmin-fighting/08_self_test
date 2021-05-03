package step8_02_atm2.copy2;

import java.util.Random;
import java.util.Scanner;

public class AccountManager2 {

	private AccountManager2() {}
	private static AccountManager2 instance = new AccountManager2();
	public static AccountManager2 getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager2 um = UserManager2.getInstance();
	

	void createAcc(int identifier) {
		//계좌만들기
		int userAccCount = um.userList[identifier].accCnt;
		
		if(userAccCount == 3) {
			System.out.println("[메시지] 최대 개설 가능 계좌수는 3개입니다.");
			return;
		}
		
		um.userList[identifier].acc[userAccCount] = new Account2();

		String makeAccount = "";

		while(true) {
			makeAccount = Integer.toString(ran.nextInt(90001)+10000);
			if(!um.getCheckAcc(makeAccount)) {
				break;
			}
		}

		
			um.userList[identifier].acc[userAccCount].accNumber = makeAccount;
			um.userList[identifier].accCnt++;
			System.out.println("[메시지] 계좌번호 " + makeAccount + "가 생성되었습니다.\n");		
	}	
	
	void deleteAcc(int identifier) {
		// 계좌 삭제
		if(um.userList[identifier].accCnt == 0) {
			System.out.println("[메시지] 계좌가 존재하지 않습니다.");
			return;
		}
		
		System.out.print("[계좌삭제] 삭제할 계좌번호를 입력하세요 : ");
		String delAccNum = scan.next();
		int findDelIdx = -1;
		
		for (int i = 0; i < um.userList[identifier].accCnt; i++) {
			if(delAccNum.equals(um.userList[identifier].acc[i].accNumber)) {
				findDelIdx = i;
			}
		}
		if(findDelIdx == -1) {
			System.out.println("[메시지] 계좌번호를 다시 확인하세요");
			return;
		}
		System.out.println(um.userList[identifier].id + "님 계좌" + delAccNum + "를 삭제하였습니다.");
		um.userList[identifier].acc[findDelIdx] = null;
		
		int j=0;
		for (int i = 0; i < um.userList[identifier].acc.length; i++) {
			if(um.userList[identifier].acc[i] != null) {
				um.userList[identifier].acc[j++] = um.userList[identifier].acc[i]; 
			}
		}
		um.userList[identifier].accCnt--;

	}
	
	void printAcc(int identifier) {
		// 계좌 출력 
		User2 temp = um.userList[identifier]; 
		System.out.println("====================");
		System.out.println("ID : " + temp.id);
		System.out.println("====================");
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println("accNumber:" +temp.acc[i].accNumber + " / money: " + temp.acc[i].money);
		}
		System.out.println("=============================\n");
		
	}
	
}



