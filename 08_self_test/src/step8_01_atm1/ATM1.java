package step8_01_atm1;

import java.util.Random;
import java.util.Scanner;


public class ATM1 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager1 userManager = new UserManager1();  // UserManager1 클래스의 인스턴스를 생성 
	int identifier = -1;  							// 로그인된 user의 User1 클래스 배열 인덱스를 파악(-1일때 로그아웃 상태) 
	
	
	void printMainMenu() {
		// 선택 메뉴 항목을 출력 
		while (true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();	
												
			if      (sel == 1) 	    login();  //3번째로 구현
			else if (sel == 2) 		logout(); 
			else if (sel == 3) 		join();   //1번째로 구현  
			else if (sel == 4) 		leave();  //2번째로 구현 
			else if (sel == 0) 		break;	   	
			
		}
		
		System.out.println("[메시지] 프로그램을 종료합니다.");
	}
	
	void login() {
		//로그인(선택메뉴 항목에서 1번 선택 시 호출) 
		identifier = userManager.logUser();
		
		if(identifier == -1) {
			System.out.println("[메시지] 로그인 실패");
		}
		else {
			printAccountMenu();
		}
		
	}
	
	void logout() {
		//로그아웃(선택메뉴 항목에서 2번 선택 시 호출)
		if(identifier == -1) {
			System.out.println("[메시지] 로그인 후 이용 가능");
		}
		else {
			System.out.println("[메시지] " + userManager.user[identifier].id + "님 로그아웃 되었습니다.");
			identifier = -1;
		}
	}
	
	void join() {
		//회원가입(선택메뉴 항목에서 3번 선택 시 호출)
		userManager.addUser();
	}
	
	void leave() {
		//탈퇴(선택메뉴 항목에서 4번 선택 시 호출)
		userManager.leave();
	}
	
	void printAccountMenu() {
		//계좌관리 => 1.계좌생성/2.삭제/3.조회/0.로그아웃
		while (true) {
			
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : "); //안내창 띄움
			// sel 정수형 변수 선언후 값입력
			int sel = scan.nextInt();				
			
			// makeAccount 문자열 변수 선언 후 10000~100000까지의 랜덤정수를 문자열로 변환 후 makeAccount에 복사
			String makeAccount = Integer.toString(ran.nextInt(90001) + 10000);
			 
			
			if (sel == 1) { // 계좌생성 선택 시
				if (userManager.user[identifier].accCount == 0) { //user클래스를 ID검색인덱스값(identifier)로 검색하여 해당accCount가 0이면
					userManager.user[identifier].acc = new Account1[1]; //해당 User클래스의 Account 클래스 배열 크기를 1로 만듬
					
					userManager.user[identifier].acc[0] = new Account1(); 		//Account배열의 0번인덱스에 인스턴스 생성
					userManager.user[identifier].acc[0].accNumber = makeAccount;	// 위의 랜덤값을 해당인스턴스의 number값에 복사
				
				}
				else { 				//user클래스를 ID검색인덱스값(identifier)로 검색하여 해당accCount가 0이 아니면
					Account1[] temp = userManager.getUser(identifier).acc; //검색된 user클래스 계정클래스배열을 temp에 복사 
//					Account[] temp2 = userManager.user[identifier].acc;
//					System.out.println("temp : " + temp);
//					System.out.println("temp : " + temp2);

					int tempAccCount = userManager.getUser(identifier).accCount; //검색된 user클래스 계정수값을 tempAccCount에 복사 
					userManager.user[identifier].acc = new Account1[tempAccCount+1]; // 계정클래스배열을 크기 1늘려 새로 생성
					for (int i = 0; i < tempAccCount; i++) {	// 현재까지의 계정클래스의 배열크기만큼 for문을 돌리고
						userManager.user[identifier].acc[i] = temp[i]; // 현재까지의 계정클래스 배열값을 순차적으로 1칸 늘린 계정클래스 배열에 복사
					}
					userManager.user[identifier].acc[tempAccCount] = new Account1(); // 계정클래스에 새로운 계정인스턴스 생성 
					userManager.user[identifier].acc[tempAccCount].accNumber = makeAccount; //새로운 계정 클래스의 넘버값에 새로운 계정번호(랜덤번호)복사
					
				}
				userManager.user[identifier].accCount++;	//계정수 1증가
				System.out.println("[메시지]'"+makeAccount +"'계좌가 생성되었습니다.\n"); // 계정 생성 안내
			} 	
			else if (sel == 2) { // 계좌 삭제 선택시 
				
				if (userManager.user[identifier].accCount == 0) {    //현재 메모리에 올라온 user클래스의 계좌수가 0이면
					System.out.println("[메시지] 더 이상 삭제할 수 없습니다.\n"); // 삭제 불가 에러 메시지
					continue;											//밑에 내용들 스킵
				}
				
				if ( userManager.user[identifier].accCount == 1) {
					System.out.println("[메시지] 계좌번호 :'"+ userManager.user[identifier].acc[0].accNumber+"' 삭제 되었습니다.\n");
					userManager.user[identifier].acc = null;
				}
				else {
					
					System.out.print("삭제 하고 싶은 계좌 번호를 입력하세요 : ");
					String deleteAccount = scan.next();
					int tempAccCount = userManager.user[identifier].accCount;
					int delIdx = -1;
					for (int i = 0; i <tempAccCount; i++) {
						if (deleteAccount.equals(userManager.user[identifier].acc[i].accNumber)) {
							delIdx = i;
						}
					}
					
					if ( delIdx == -1 ) {
						System.out.println("[메시지] 계좌번호를 확인하세요.\n");
						continue;
					}
					else {
						System.out.println("[메시지] 계좌번호 :'"+ userManager.user[identifier].acc[delIdx].accNumber+"' 삭제 되었습니다.\n");
						
						Account1[] temp = userManager.user[identifier].acc;
						userManager.user[identifier].acc = new Account1[tempAccCount-1];
						
						
						for (int i = 0; i < delIdx; i++) {
							userManager.user[identifier].acc[i] = temp[i];
						}
						for (int i = delIdx; i < tempAccCount - 1; i++) {
							userManager.user[identifier].acc[i] = temp[i+1];
						}
					}
					
				}
				userManager.user[identifier].accCount--;
				
			}
			
			else if (sel == 3) {
				if (userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 생성된 계좌가 없습니다.\n");
				}
				else {
					userManager.user[identifier].printAccount();
				}
			}   
			else if (sel == 0) {
				logout();
				break;
			}
			
		}
	}
	
}
