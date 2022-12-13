package project02;
 
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
       EzenCompany company = new EzenCompany();
        Scanner input = new Scanner(System.in);
        String loginID = null, loginPWD = null; // 로그인, 회원가입 (변수)
        String workernum = null; // 삭제
        String mode = "";

        int i= 0;
        while(i<3) {            
           if(loginID==null) { //아직 로그인하기 전 상황이면 
              System.out.println("=== EZEN COMPANY 사원 관리 프로그램 ===");
              System.out.println("  ┌────────────────────────┐");
              System.out.println("  │         로 그 인         │");
              System.out.println("  └────────────────────────┘");
              String enterID = "";
              String enterPWD = "";
               
              System.out.print("   아이디  : ");
              enterID = input.nextLine();
              System.out.println();
              System.out.print("   비밀번호 : ");
              enterPWD = input.nextLine();
              
              if ( enterID.equals("1") && enterPWD.equals("1") ) {
                 mode = "관리자";
                 loginID = enterID;
                 break;
              } else if ( enterID.equals("2") && enterPWD.equals("2") ) {
                 mode = "사용자";
                 loginID = enterID;
                 break;
              } else {
                 System.out.println("\n ID 또는 Password를 다시 확인해 주세요.\n");
                 i++;
                 if (i == 3) {
                      System.out.println(" ID 및 Password 입력을 3회 초과하였습니다.");
                      System.out.println("\n\n 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
                       System.out.print(" 접근 위반입니다. \n   다시 시도해 주세요");
                       
                       System.out.print("."); company.timer(800);
                       System.out.print("."); company.timer(800);
                       System.out.print("."); company.timer(800);
                       System.out.print("."); company.timer(800);
                       System.out.println();
                       System.out.println("    3초 후 자동으로 종료됩니다.");
                       company.timer(800); company.timer(800); company.timer(800); 

                       System.out.println("\n\n 〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
                       System.out.println("\n    시스템을 종료합니다.");
                       System.exit(0);
                   }    
                 continue;                 
              }            
           }
        }
           
        while(true) {
            System.out.println("======== " + mode + "님 환영합니다! ========");
            System.out.println("  [" + mode +"모드 프로그램을 시작합니다 ]");
            System.out.println("1. 등록");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 검색");
            System.out.println("6. 종료");
            System.out.print(">>>");
            int select = input.nextInt();
            switch (select) {
            case 1:
               if(mode.equals("관리자")) {
                  company.saveWorker();
               } else if(mode.equals("사용자")){
                  company.saveWorker2();
               }
                continue;
            case 2:
               if(mode.equals("관리자")) {
                  company.output();
               } else if(mode.equals("사용자")){
                  System.out.println("열람 권한이 없습니다.");
                  System.out.println();
               }
                continue;
            case 3:
               if(mode.equals("관리자")) {
                  company.modify();
               } else if(mode.equals("사용자")){
                  System.out.println("수정 권한이 없습니다.");
                  System.out.println();
               }
                continue;
            case 4: //삭제
            	if(mode.equals("관리자")) {
                    company.delete();
                 } else if(mode.equals("사용자")){
                    System.out.println("수정 권한이 없습니다.");
                    System.out.println();
                 }
                  continue;      
            case 5:
               if(mode.equals("관리자")) {
                  System.out.println("1. 사원 정보 | 2. 연차 조회 | 3. 수당 조회");
               } else if(mode.equals("사용자")){
                  company.search2();
               }
                continue;                
            case 6: // 종료
            	System.out.println("\n\n 〓〓〓〓〓〓〓〓〓〓〓");
                System.out.println(" 프로그램을 종료합니다. \n");
                System.exit(0);
            default:
                System.out.println("잘못된 입력");
                continue;
            }
        }
    
    }
}