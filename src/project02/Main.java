package project02;
 
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
       EzenCompany company = new EzenCompany();
        Scanner input = new Scanner(System.in);
        //사원 아이디, 비밀번호 지정
        //String loginID = "ezen", loginPWD = "ezen12345"; // management ID, Password
        //String employeeID = "me", employeePWD = "12345"; // employee ID, Password [temporary]
        
        String loginID = "1", loginPWD = "1";
        String employeeID = "2", employeePWD = "2";
        
        while(true) {
            System.out.println("=== EZEN COMPANY 사원 관리 프로그램 ===");
            System.out.println("  ┌────────────────────────┐");
            System.out.println("  │         로 그 인         │");
            System.out.println("  └────────────────────────┘");
            int i = 0;
            String enterID = null;
            String enterPWD= null;
            
            for (; i < 3; i++ ) {
	            System.out.print("   아이디  : ");
	            enterID = input.nextLine();
	            System.out.print("   비밀번호 : ");
	            enterPWD = input.nextLine();
            
	            
	            //관리자 및 사용자 아이디 및 패스워드 확인
	            if ( enterID.equals(loginID) && enterPWD.equals(loginPWD) ) {
	            	mainMenu("관리자");
	              break;
	            }
	            else if ( enterID.equals(employeeID) && enterPWD.equals(employeePWD) ) {
	            	mainMenu("누구누구");
	            	break;
	            }
	            System.out.println("\n ID 또는 Password는 다시 확인해 주세요.\n");
	            if (i == 2) {
	            	System.out.println(" ID 및 Password 입력을 3회 초과하였습니다.");
	            	System.out.println("\n\n 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
	                System.out.print(" 접근 위반입니다. \n   다시 시도해 주세요");
	                
	                System.out.print("."); timer(800);
	                System.out.print("."); timer(800);
	                System.out.print("."); timer(800);
	                System.out.print("."); timer(800);
	                System.out.println();
	                System.out.println("    3초 후 자동으로 종료됩니다.");
	                timer(800); timer(800); timer(800); 

	                System.out.println("\n\n 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
	                System.out.println("\n    시스템을 종료합니다.");
	                System.exit(0);
	            }    
            }	
           	
            int select = input.nextInt();
            switch (select) {
            case 1: // 등록
            	   if(enterID.equals(loginID)) {
            		   company.saveWorker();
                  }else {
                	  	System.out.println("\n등록 권한이 없습니다.\n");
                  }
                   break;

            case 2: // 출력
            	 if(enterID.equals(loginID)) {
                     company.output();
                  }else {
                     System.out.println("\n열람 권한이 없습니다.\n");
                  }
                   break;

            case 3: // 수정
            	 if(enterID.equals(loginID)) {
                     company.modify();
                  }else {
                     System.out.println("\n수정 권한이 없습니다.\n");
                  }
            	 	break;
            case 4: // 검색
                company.search();
                break;            
            case 5: // 종료
            	System.out.println("\n\n 〓〓〓〓〓〓〓〓〓〓〓");
                System.out.println(" 프로그램을 종료합니다. \n");
                System.exit(0);
            default:
                System.out.println("잘못된 입력");
                continue;
            }
        }
    } 
    
    // 관리자 및 사용자 검증
  	public static void confirm(String enterID, String loginID, String enterPWD, String loginPWD, String employeeID, String employeePWD ) {
  		if ( enterID.equals(loginID) && enterPWD.equals(loginPWD) ) {
         	mainMenu("관리자");
         }
         else if ( enterID.equals(employeeID) && enterPWD.equals(employeePWD) ) {
         	mainMenu("사용자");
         }
  	}
    
    // 관리자 또는 사용자 메뉴 - 콘솔 출력 [함수 생성]
 	public static void mainMenu(String mode) {
 		System.out.println();
         System.out.println("======== " + mode + "님 환영합니다! ========");
         System.out.println("  [" + mode +"모드 프로그램을 시작합니다 ]");
         System.out.println("1. 등록");
         System.out.println("2. 출력");
         System.out.println("3. 수정");
         System.out.println("4. 검색");
         System.out.println("5. 종료");
         System.out.print(">>>");
 	}
 	
 	// 로그인 3회 입력 오류 시 종료 타이머 설정
 	public static void timer(int mTime) {
 		try { Thread.sleep(mTime); }  catch (Exception e) {System.out.print(""); };
 	}
 	
 // 연차휴가수당 
  	public static void weeklyAllowance(int money, int time) {
  		int minimumWage, workingHours;
  		minimumWage = money;
  		workingHours = time;
  		System.out.println(minimumWage * workingHours);
  	}
  	
  	// 초과 근로 수당, 야간 수당, 특별 수당, 휴일 수당
  	public static void specialPay(int money, int time) {
  		int minimumWage, workingHours;
  		double multiple = 1.5;
  		minimumWage = money;
  		workingHours = time;
  		System.out.println((int)(minimumWage * multiple) * workingHours);
  	}
  	
  	// 휴일 수당 중 초과 근무 수당
  	public static void overtimePay(int money, int time) {
 		int minimumWage, workingHours, multiple = 2;
 		minimumWage = money;
 		workingHours = time;
 		System.out.println((minimumWage * multiple) * workingHours);
 	}
}