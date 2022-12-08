package project02;
 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       EzenCompony company = new EzenCompony();
        Scanner input = new Scanner(System.in);
        //사원 아이디, 비밀번호 지정
        String managerID = "ezen";
        String managerPWD = "ezen12345";
        
        while(true) {
            System.out.println("=== EZEN COMPANY 사원 관리 프로그램 ===");
            System.out.println("  ┌────────────────────────┐");
            System.out.println("  │         로 그 인         │");
            System.out.println("  └────────────────────────┘");
            System.out.print("   아이디 : ");
            String enterID = input.nextLine();
            System.out.print("   비밀번호 : ");
            String enterPWD = input.nextLine();
            
            //관리자 모드 아이디 비밀번호 매치 확인
            if(!enterID.equals(managerID) && !enterPWD.equals(managerPWD)) {
               System.out.println("\n ****아이디와 비밀번호를 다시 확인해주세요****");
            } else if(enterID.equals(managerID) && !enterPWD.equals(managerPWD)) {
               System.out.println("\n *****비밀번호를 다시 확인해주세요*****");
            } else if(!enterID.equals(managerID) && enterPWD.equals(managerPWD)) {
               System.out.println("\n *****아이디를 다시 확인해주세요*****");
            } else {
               System.out.println();
               System.out.println("======== 관리자님 환영합니다! ========");
               System.out.println("  [ 관리자 모드 프로그램을 시작합니다 ]");
               System.out.println("1. 등록");
               System.out.println("2. 출력");
               System.out.println("3. 수정");
               System.out.println("4. 검색");
               System.out.println("5. 종료");
               System.out.print(">>>");
            }
            
            int select = input.nextInt();
            switch (select) {
            case 1:
                company.saveWorker();
                break;
            case 2:
                company.output();
                break;
            case 3:
                company.modify();
                break;
            case 4:
                company.search();
                break;            
            case 5:
                System.exit(0);
            default:
                System.out.println("잘못된 입력");
                break;}
            }
        } 
}