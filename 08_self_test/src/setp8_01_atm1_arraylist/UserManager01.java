package setp8_01_atm1_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager01 {

	Scanner scan = new Scanner(System.in);
	ArrayList<User01> user = new ArrayList<User01>();; 				//배열은 null로 초기화해줌 ==> User1[] user = null;	
	int userCount = 0;
	
	void printAllUser() {
		for (int i = 0; i < user.size(); i++) {
			user.get(i).printAccount();
		}
	}
	
	void addUser() {
		System.out.print("[가입] ID 입력 : ");
		String id = scan.next();
		
		boolean isDuple = false;
		for (int i = 0; i < user.size(); i++) {
			if(user.get(i).id.contentEquals(id)) {
				isDuple = true;
			}
		}
		
		if(!isDuple) {
			User01 user01 = new User01();
			user.add(user01);
			user.get(userCount).id = id;
			System.out.println("[메시지] " + id + "님 가입되었습니다.");
			userCount++;
		}
		else {
			System.out.println("[메시지] 이미 가입된ID입니다.");
		}	
	}
	
	User01 getUser(int idx) {
		return user.get(idx);
	}
	
//	int logUser() {}
	void leave() {}
}
