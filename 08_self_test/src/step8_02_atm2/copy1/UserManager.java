package step8_02_atm2.copy1;

import java.util.Random;
import java.util.Scanner;

public class UserManager {
	
	//싱글톤
	private UserManager() {}
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	final int ACC_MAX_CNT = 3;			// 최대 개설 가능한 계좌 수
	User[] userList = null;				// 전체 회원정보
	int userCnt = 0;					// 전체 회원 수
	
	
//	void printAllUser() {}
	
	
//	boolean getCheckAcc(String account) {}
	
	
//	int logUser() {}
	
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
		
	}

	
//	int deleteMember(int identifier) {}
	
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
