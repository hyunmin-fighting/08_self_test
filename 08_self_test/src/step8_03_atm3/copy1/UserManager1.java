package step8_03_atm3.copy1;


public class UserManager1 {
	
	private UserManager1() {}
	private static UserManager1 instance = new UserManager1();
	static UserManager1 getInstance() {
		return instance;
	}
	
	
	User1[] userList;
	int userCount;
	int identifier = -1;


	void printAllUserInfo() {
		System.out.println("아이디\t패스워드\t계좌정보");
		for (int i = 0; i < userCount; i++) {
			userList[i].printOneUserAllAccounts();
		}
		System.out.println("--------------------------");
	}
	
	
	void setDummy() {
		
		userCount = 5;
		userList = new User1[userCount];
		for (int i=0; i<userCount; i++) {
			userList[i] = new User1();
		}
				
		String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
		String[] b = {"l", "b", "c", "m", "e", "f", "g", "n", "i", "p", "k"};
		String[] c = {"s", "t", "u", "w", "v", "o", "x", "n", "q", "p", "r"};
		
		for (int i=0; i<userCount; i++) {
			String id = "";
			int rNum = ATM1.ran.nextInt(a.length);
			id += a[rNum];
			rNum = ATM1.ran.nextInt(b.length);
			id += b[rNum];
			rNum = ATM1.ran.nextInt(c.length);
			id += c[rNum];
			
			userList[i].id = id;
		}
		
		String[] d = {"1", "8", "9", "4"};
		String[] e = {"2", "7", "0", "6"};
		String[] f = {"5", "3", "2", "7"};
		
		for (int i=0; i<userCount; i++) {
			String pw = "";
			int rNum = ATM1.ran.nextInt(d.length);
			pw += d[rNum];
			rNum = ATM1.ran.nextInt(e.length);
			pw += d[rNum];
			rNum = ATM1.ran.nextInt(f.length);
			pw += d[rNum];
			
			userList[i].password = pw;
		}
		
		System.out.println("[메세지]더미 파일이 추가되었습니다.\n");
	}

	
	int checkId(String id) {
		int identifier = -1;
		for (int i = 0; i < userCount; i++) {
			if(userList[i].id.equals(id)) {
				identifier = i;
			}
		}
		return identifier;
	}
	
	void joinUser() {
		//회원 가입
		System.out.println("[회원가입] ID입력 : ");
		String id = ATM1.scan.next();
		int checkedId = checkId(id);
		
		if(checkedId != -1) {
			System.out.println("[메세지]아이디가 중복됩니다.\n");
			return;
		}
		System.out.println("[회원가입] PW입력 : ");
		String pw = ATM1.scan.next();

		if(userCount == 0) {
			userList = new User1[1];
			userList[0] = new User1(id, pw);
		}
		
		else if(userCount > 0) {
			User1[] temp = userList;
			
			userList = new User1[userCount + 1];
			for (int i = 0; i < userCount; i++) {
				userList[i] = temp[i];
			}
			
			userList[userCount] = new User1(id, pw);
			temp = null;

		}
		userCount++;
		System.out.println("회원가입 완료");
	}
	
	
	void leaveUser() {
		//로그인된 상태에서 회원탈퇴 처리
		if(userCount == 1) {
			userList = null;
		}
		else if(userCount > 1) {
				
			User1[] temp = userList;
			userList = new User1[userCount - 1];
			
			int j=0;
			for (int i = 0; i < userCount; i++) {
				if(identifier != i) {
					userList[j++] = userList[i];
				}
			}
		}
		userCount--;
		System.out.println("탈퇴완료\n");
		logoutUser();
	}
	
	
	void loginUser() {
		//로그인 
		System.out.println("[로그인] ID 입력 : ");
		String id = ATM1.scan.next();
		System.out.println("[로그인] PW 입력 : ");
		String pw = ATM1.scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if(userList[i].id.equals(id) && userList[i].password.equals(pw)) {
				identifier = i;
			}
		}
		
		if(identifier == -1) {
			System.out.println("[메세지]아이디와 패스워드가 틀렸습니다.\n");
		}
		else {
			System.out.println("[메시지] " + userList[identifier].id + "님 환영합니다.\n");
			afterloginMenu();
		}
		
	}
	
	
	void logoutUser() {
		identifier = -1;
		System.out.println("[메시지] 로그아웃되었습니다.\n");
	}
	
	
	void afterloginMenu() {

		while (true) {
			
			System.out.println("[" + userList[identifier].id + "님, 로그인]");
			System.out.println("[1]계좌생성 [2]입금하기 [3]출금하기 [4]이체하기 [5]계좌조회 "
					+ "[6]계좌삭제 [7]회원탈퇴 [0]뒤로가기");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = ATM1.scan.nextInt();
			
			if (choice == 1)  {
				AccountManager1.getInstance().createAccount(); 
			}
			else if (choice == 2) {
				AccountManager1.getInstance().income(); 
			}
			else if (choice == 3) {
				AccountManager1.getInstance().outcome();
			}
			else if (choice == 4) {
				AccountManager1.getInstance().transfer(); 
			}
			else if (choice == 5) {
				AccountManager1.getInstance().lookupAcc(); 
			}
			else if (choice == 6) {
				AccountManager1.getInstance().deleteAcc(); 
			}
			else if (choice == 7) {
				leaveUser();
				break;
			}
			else if (choice == 0) {
				logoutUser();
				break; 
			}
			
		}
		
	}
	
	
}









