package step8_01_atm1;

import java.util.Scanner;

public class UserManager1 {

	
	Scanner scan = new Scanner(System.in);
	User1[] user = null;					// UserManager1 Class에서 user Class를 배열로 인스턴스 관리
	int userCount = 0;						// 인스턴스 생성된 User Class 수를 확인하기 위함
	
	void printAllUser() {
		// 모든 고객의 모든 계좌정보를 출력 
		for (int i = 0; i < userCount; i++) {
			user[i].printAccount();
		}
	}
	
	
	void addUser() {
		// 신규 고객을 추가(회원 가입) 
		if(userCount == 0) {
			user = new User1[1];	
		}
		//고객클래스가 없으면 새로 고객클래스 배열 크기 1로 생성 
		else {
			User1[] temp = user;
			user = new User1[userCount + 1];
			for (int i = 0; i < userCount; i++) {
				user[i] = temp[i];
			}
			//고객클래스가 있으면 기존 고객 클래스 배열값 temp로 옮기고 신규로 배열 사이즈 1늘려 생성 후 temp값을 재 복사 
			temp = null;
		}
		
		System.out.print("[가입] ID 입력 : ");
		String id = scan.next();
		
		boolean isDuple = false;
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) {
				isDuple = true;
			}
		}
		//입력받은 ID값이 user 배열에 중복이 있는지 검사 
		
		if(!isDuple) {
			user[userCount] = new User1();
			user[userCount].id = id;
			//중복이 없으면 User클래스 인스턴스 생성 후 입력받은 ID값 복사 
			System.out.println("[메시지] " + id + "님 가입되었습니다.");
			userCount++;
		}
		else {
			System.out.println("[메시지] 이미 가입된 ID입니다.");
		}
		
		
	}
	
	
	User1 getUser(int idx) {
		// 특정 고객 클래스를 가져옴
		
		return user[idx];
	}
	
	
	
	int logUser() {
		// 특정 고객 로그인 
		int identifier = -1;
		System.out.println("[로그인] ID 입력 : ");
		String id = scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) {
				identifier = i;
				System.out.println("[메시지]" + user[identifier].id + "님 로그인 되었습니다.");
			}
		}
		
		return identifier;
	}
	
	void leave() {
		// 특정고객 삭제(탈퇴)
		System.out.print("[탈퇴] ID 입력 : ");
		String id = scan.next();
		int identifier = -1; //로그인 식별자 선언 및 -1로 초기화
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) {
				identifier = i;
			}
		}
		// user 클래스 배열에서 입력받은 id와 일치하는 id가 있는지 for문을 통해 userCount수만큼 순회하여 확인
		if(identifier == -1) {
			System.out.println("[메시지] ID를 다시 확인하세요.");
			return;
		}
		else {
			//입력받은 ID와 일치하는ID가 특정 User 클래스(identifier)에 있으면 
			System.out.println("[메시지] " + user[identifier].id + "님 탈퇴되었습니다.");
			User1[] temp = user;
			user = new User1[userCount - 1];
			for (int i = 0; i < identifier; i++) {
				user[i] = temp[i];
			}
			for (int i = identifier; i < userCount-1; i++) {
				user[i] = temp[i+1];
			}
		}
		userCount--;
	}
	
}
