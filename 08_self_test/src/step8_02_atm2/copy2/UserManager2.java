package step8_02_atm2.copy2;

import java.util.Random;
import java.util.Scanner;

public class UserManager2 {
	
	private UserManager2(){}
	private static UserManager2 instance = new UserManager2();
	public static UserManager2 getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	final int ACC_MAX_CNT = 3;			// 최대 개설 가능한 계좌 수
	User2[] userList = null;				// 전체 회원정보
	int userCnt = 0;					// 전체 회원 수
	
	void printAllUser() {
		// 고객들의 계좌정보를 출력
//		1.ID(김현민)	PW(1212)	(3184763:0,)
//		2.ID(김주원)	PW(2323)	
//		3.ID(한원규)	PW(3434)	
		
		for (int i = 0; i < userCnt; i++) {
			System.out.print((i+1)+". ID(" + userList[i].id + ")\tPW(" + userList[i].pw + ")\t");
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
				if(userList[i].acc[j].accNumber.equals(account)){
					isDuple = true;
				}
			}
		}
		return isDuple;
	}
	
	
	int logUser() {
		//로그인 시키지
			/*
			 * 스캐너로 ID/PW입력
			 * userList 참조변수에서 일치ID/PW검색
			 * 일치할 경우 해당 인덱스값 반환
			 */
		int identifier = -1;
		
		System.out.print("[로그인] ID를 입력하세요  :");
		String id = scan.next();
		System.out.print("[로그인] PW를 입력하세요  :");
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
			if(id.equals(userList[i].id)) {
				isDuple = true;
			}
		}
		return isDuple;
	}
	
	
	void joinMember() {
		//가입시키기
			//1.스캐너로 ID입력
			//2.userList에서 중복 검색 => CheckId()메서드 활용
			//3.User객체생성 및 ID/PW 복사
		System.out.print("[가입] ID를 입력하세요  :");
		String id = scan.next();
		boolean isResult = checkId(id);
		if(isResult) {
			System.out.println("[메시지] 이미 가입된 ID입니다.");
		}
		else {
			System.out.print("[가입] PW를 입력하세요 :");
			String pw = scan.next();
			
			User2[] temp = userList;
			userList = new User2[userCnt + 1];
			for (int i = 0; i < userCnt; i++) {
				userList[i] = temp[i];
			}
			temp = null;
			
			userList[userCnt] = new User2();
			userList[userCnt].id = id;
			userList[userCnt].pw = pw;
			userCnt++;
			System.out.println("[메시지] " + id + "님 정상 가입 처리되었습니다.");
		}
	}

	
	int deleteMember(int identifier) {
		//삭제시키기
			User2[] temp = userList;
			userList = new User2[userCnt - 1];
			for (int i = 0; i < identifier; i++) {
				userList[i] = temp[i];
			}
			for (int i = identifier; i < userCnt - 1; i++) {
				userList[i] = temp[i+1];
			}
				System.out.println("[메시지] 탈퇴되었습니다.");
				userCnt--;
		return identifier;
	}
	
	// (테스트생성용 메서드)  : 테스트 데이타 > 더미
	void setDummy() {
		
		String[] ids  = {"user1"  ,  "user2",     "user3",    "user4",    "user5"};
		String[] pws  = {"1111"   ,   "2222",      "3333",     "4444",    "5555"};
		String[] accs = {"1234567",  "2345692",  "1078912",   "2489123",  "7391234"};
		int[] moneys  = { 87000   ,     12000,    49000,        34000,     128000};
		
		userCnt = 5;
		userList = new User2[userCnt];
		
		for (int i=0; i<userCnt; i++) {
			userList[i] = new User2();
			userList[i].id = ids[i];
			userList[i].pw = pws[i];
			userList[i].acc[0] = new Account2();
			userList[i].acc[0].accNumber = accs[i];
			userList[i].acc[0].money = moneys[i];
			userList[i].accCnt++;
		}
		
	}
	
}
