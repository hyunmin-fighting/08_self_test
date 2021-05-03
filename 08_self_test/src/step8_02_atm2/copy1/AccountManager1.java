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
	
	// 계좌 삭제 = self구현
	void deleteAcc(int identifier) {
		//현재 로그인고객의 계좌수를 받아온다
		//만약 계좌수가 0개면 "[메시지] 계좌가 존재하지 않습니다" 출력
		//만약 계좌수가 1개면 um.userList[identifier].acc = null; 처리
		//그밖에 계좌수이면 
		 	//현재 계좌정보를 Account1[] tempAccount에 복사
		   	//
		
		int currentAccCnt = um.userList[identifier].accCnt;
							
		if(currentAccCnt == 0) {
			System.out.println("[메시지] 계좌가 존재하지 않습니다.");
			return;
		}
		
		int delAccIdx = -1;
		if(currentAccCnt == 1) {
			System.out.println("[메시지] 계좌번호" + um.userList[identifier].acc[0].accNumber + "를 삭제하였습니다.");
			um.userList[identifier].acc = null;
		}
		
		else if(currentAccCnt > 1) {
			System.out.print("[계좌삭제] 삭제할 계좌번호 입력 : ");
			String delAccNum = scan.next();
			for (int i = 0; i < currentAccCnt; i++) {
				if(delAccNum.equals(um.userList[identifier].acc[i].accNumber)) {
					delAccIdx = i;
				}
			}
			
			if(delAccIdx == -1) {
				System.out.println("[메시지] 계좌번호를 다시 확인하세요");
				return;
			}
			
			if(delAccIdx != -1) {
				System.out.println("[메시지] 계좌번호" + um.userList[identifier].acc[delAccIdx].accNumber + "를 삭제하였습니다.");
				um.userList[identifier].acc[delAccIdx] = null;
			}
			
			int j = 0;
			for (int i = 0; i < um.userList[identifier].acc.length; i++) {
				if(um.userList[identifier].acc[i] != null) {
					um.userList[identifier].acc[j++] = um.userList[identifier].acc[i];
				}
			}
		}
		
		um.userList[identifier].accCnt--;
		
	}
	
	
	// 계좌 출력
	void printAcc(int identifier) {
		
		User1 temp = um.userList[identifier];
		System.out.println("====================");
		System.out.println("ID : " + temp.id);
		System.out.println("====================");
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println("accNumber : " + temp.acc[i].accNumber + "/ money : " + temp.acc[i].money);
		}
		System.out.println("=============================\n");

	}
	
}
