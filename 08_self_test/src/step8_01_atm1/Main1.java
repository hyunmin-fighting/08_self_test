package step8_01_atm1;

public class Main1 {

	public static void main(String[] args) {
//설계 순서 : Account클래스 완성 => User클래스 완성 => [ATM클래스 껍데기 => UserManager클래스 껍데기] => Main클래스 완성
//		   =>(회원가입 구현) userManager클래스 addUser메서드 => ATM클래스 join메서드
// 		   =>(회원탈퇴 구현) userManager클래스 leave메서드 => ATM클래스 leave메서드
//		   =>(로그인 구현) userManager클래스 login메서드 => ATM클래스 login메서드 => (아직구현X)ATM클래스의 printAccountMenu메서드	
//		   =>(로그아웃 구현) ATM클래스 logout메서드  
//		   =>(계좌출력메서드 구현)UserManager클래스 printAllUser메서드 구현 
//		   =>(계좌관리 구현) ATM클래스 printAccountMenu메서드
			
		ATM1 atm = new ATM1();
		atm.printMainMenu();
	}

}
