package step8_02_atm2.copy1;

import java.util.Random;
import java.util.Scanner;

public class UserManager1 {
	
	//싱글톤
	private UserManager1() {}
	private static UserManager1 instance = new UserManager1();
	public static UserManager1 getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	final int ACC_MAX_CNT = 3;			// 최대 개설 가능한 계좌 수
	User1[] userList = null;				// 전체 회원정보
	int userCnt = 0;					// 전체 회원 수
	
	
	void printAllUser() {
		for (int i = 0; i < userCnt; i++) {
			System.out.print((i+1) + ".ID(" + userList[i].id + ")\tPW(" + userList[i].pw + ")\t");
			if(userList[i].accCnt != 0) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					System.out.print("(" + userList[i].acc[j].accNumber + ":" + userList[i].acc[j].money + ")");
				}
			}
			System.out.println();
		}
	}
	
	
	boolean getCheckAcc(String account) {
		boolean isDuple = false;
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if(userList[i].acc[j].accNumber.equals(account)) {
					isDuple = true;
				}
			}
		}
		return isDuple;
	}
	
	
	int logUser() {
		
		int identifier = -1;
		
		System.out.print("[로그인] ID입력 요청 : ");
		String id = scan.next();
		System.out.print("[로그인] PW입력 요청 : ");
		String pw = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if(userList[i].id.equals(id) && userList[i].pw.equals(pw)) {
				identifier = i;
			}
		}
		return identifier;
	}
	
	boolean checkId(String id) {
		
		boolean isDuple = false;
		
		for (int i = 0; i < userCnt; i++) {
			if(userList[i].id.equals(id)) {
				isDuple =true;
			}
		}
		
		return isDuple;
	}
	
	
	void joinMember() {
		
		System.out.print("[회원가입] ID 입력 요청 : ");
		String id = scan.next();
		System.out.print("[회원가입] PW 입력 요청 : ");
		String pw = scan.next();
		
		boolean isResult = checkId(id); //checkId 메서드를 통해 id중복확인 후 결과값을 반환 받는다.
		
		if(isResult) {
			System.out.println("[메시지] ID가 중복입니다.");
			return;
		}
		
		if(userCnt == 0) {
			userList = new User1[userCnt+1];
			userList[userCnt] = new User1();
		}
		
		else {
			User1[] tempList = userList;
			userList = new User1[userCnt + 1];
			for (int i = 0; i < userCnt; i++) {
				userList[i] = tempList[i];
			}
			tempList = null;
		}
		
		userList[userCnt] = new User1();
		userList[userCnt].id = id;
		userList[userCnt].pw = pw;
		userCnt++;
		
		System.out.println("[메시지] " + id + "님 회원 가입을 축하합니다.");
		//저장 미구현.....
	}

	
	int deleteMember(int identifier) {
		
		User1[] temp = userList;
		userList = new User1[userCnt - 1];
		int j = 0;
		for (int i = 0; i < userCnt; i++) {
			if(i != identifier) {
				userList[j++] = temp[i];
			}
		}
		userCnt--;
		temp = null;
		identifier = -1;
		
		System.out.println("[메시지] 탈퇴되었습니다.");
		// 저장 미구현....
		return identifier;
		
	}
	
	// (테스트생성용 메서드)  : 테스트 데이타 > 더미
//	void setDummy() {
//		
//		String[] ids  = {"user1"  ,  "user2",     "user3",    "user4",    "user5"};
//		String[] pws  = {"1111"   ,   "2222",      "3333",     "4444",    "5555"};
//		String[] accs = {"1234567",  "2345692",  "1078912",   "2489123",  "7391234"};
//		int[] moneys  = { 87000   ,     12000,    49000,        34000,     128000};
//		
//		userCnt = 5;
//		userList = new User[userCnt];
//		
//		for (int i=0; i<userCnt; i++) {
//			userList[i] = new User();
//			userList[i].id = ids[i];
//			userList[i].pw = pws[i];
//			userList[i].acc[0] = new Account();
//			userList[i].acc[0].accNumber = accs[i];
//			userList[i].acc[0].money = moneys[i];
//			userList[i].accCnt++;
//		}
//		
//	}
	
}
