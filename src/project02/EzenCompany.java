package project02;
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class EzenCompany implements Company {
    ArrayList<CompanyBasics> arr = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    String employeeNumber;
	private CompanyBasics cb;
    
    public void timer(int mTime) {
        try { Thread.sleep(mTime); }  catch (Exception e) {System.out.print(""); };
     }
    
    
    @Override
    public void saveWorker() { //관리자 (1. 등록)
        String name;
        String jobRank;
        int basicSalary;
        int bonus;
        double taxRate;
        int monthSalary;
        
        CompanyBasics cb = new CompanyBasics();
        System.out.print("사원 번호 : ");
        employeeNumber = input.next();
        System.out.print("사원 이름 : ");
        name = input.next();
        System.out.print("직급 : ");
        jobRank = input.next();
        System.out.println("기본급 : ");
        basicSalary = input.nextInt();
        System.out.println("수당 : ");
        bonus = input.nextInt();
        cb.setEmployeeNumber(employeeNumber);
        cb.setName(name);
        cb.setJobRank(jobRank);
        cb.setBasicSalary(basicSalary);
        cb.setBonus(bonus);
        cb.getTaxRate();
        cb.getMonthSalary();
        arr.add(cb);
        System.out.println("등록 완료!!");
    }
    
    @Override
    public void saveWorker2() { //사용자 (1. 등록) 
       //입사연월, 이름, 주소, 전화번호 등록
       String enterYear;
       String name;
        String address;
        String phoneNum;
        String employeeNumber;
        CompanyBasics cb = new CompanyBasics();
        System.out.print("사원 번호 : ");
        employeeNumber = input.next();
        System.out.print("사원 이름 : ");
        name = input.next();
        System.out.print("입사연월 : ");
        enterYear = input.next();
        System.out.print("주소 : ");
        address = input.next();
        System.out.print("전화번호 : ");
        phoneNum = input.next();
        cb.setEmployeeNumber(employeeNumber);
        cb.setName(name);
        cb.setEnterYear(enterYear);
        cb.setAddress(address);
        cb.setPhoneNum(phoneNum);
        arr.add(cb);
        System.out.println("등록 완료!!");
        System.out.println();
    }
    
    @Override
    public void modify() {//수정
        System.out.println("수정할 사원의 사원 번호를 입력하세요. : ");
        String employeeNumber = input.next();
        boolean flag = true;
        for (int i = 0 ; i < arr.size(); i++) {
            if (arr.get(i).getEmployeeNumber().equals(employeeNumber)) {
                 flag = false;
                 System.out.print("사원 번호 입력 : ");
                 employeeNumber = input.next();
                 System.out.print("직급 입력     : ");
                 String modiJobRank = input.next();
                 arr.get(i).setJobRank(modiJobRank);
                 System.out.print("기본급 변경 입력 : ");
                 int modiSalary = input.nextInt();
                 arr.get(i).setBasicSalary(modiSalary);
                 System.out.print("수당 변경 입력  : ");
                 int modiBounus = input.nextInt();
                 arr.get(i).setBonus(modiBounus);
                 System.out.print("수정이 정상적으로 완료되었습니다.");
                 break;
            }
        }
        if (flag) {
            System.out.println("해당 사원이 없습니다.");
        } 
    }
    
    @Override 
    public void delete() {
    	System.out.print("사원번호 입력 : ");
    	String employeeNumber2 = input.next();
    	int num = Integer.parseInt(employeeNumber2);
    	
    	for (int i = 0; i < arr.size() ;i++) {
			if(employeeNumber.equals(employeeNumber)){ // 사원번호가 존재하면
				cb.getEmployeeNumber();
				//arr.remove(0 + (Integer.parseInt(employeeNumber2)));
				if (num == 0) continue;
				//int inde = arr.indexOf(0);
				
				arr.remove(num - 1);
				System.out.println("삭제가 완료되었습니다.");
				
				break;
			} 
			else {//사원번호가 존재하지 않는다면
				System.out.println("존재하지 않는 사원번호입니다.");
			}
    	}
    }

    @Override
    public void search() {
        System.out.print("사원번호를 입력하세요 : ");
        String employeeNumber = input.next();
        boolean flag = true;
        for (int i = 0 ; i < arr.size(); i++) {
            if (arr.get(i).getEmployeeNumber().equals(employeeNumber)) {
                flag = false;
                System.out.println("사원번호 : "+arr.get(i).getEmployeeNumber());
                System.out.println("이름    : "+arr.get(i).getName());
                System.out.println("직급    : "+arr.get(i).getJobRank());
                System.out.println("기본급   : "+arr.get(i).getBasicSalary());
                System.out.println("수당    : "+arr.get(i).getBonus());
                System.out.println("세율    : "+arr.get(i).getTaxRate());
                System.out.println("월급    : "+arr.get(i).getMonthSalary());
                break;
            }
        }
        if (flag) {
            System.out.println("해당 사원이 없습니다.");
        }
    }


    @Override
    public void search2() { //관리자 
        System.out.print("사원번호를 입력하세요 : ");
        String employeeNumber = input.next();
        boolean flag = true;
        for (int j = 0 ; j <arr.size(); j++) {
            if (arr.get(j).getName().equals(employeeNumber)) {
                flag = false;
                System.out.println("이름 : "+arr.get(j).getName());
                System.out.println("입사년도 : "+arr.get(j).getEnterYear());
                System.out.println("주소 : "+arr.get(j).getAddress());
                System.out.println("전화번호 : "+arr.get(j).getPhoneNum());
                break;
            }
        }
        if (flag){
            System.out.println("해당 사원이 없습니다.");
        }

    }
   
    @Override
    public void output() {
        System.out.println("==============================모든 사원 정보 출력================================");
        System.out.println("──────────────────────────────────────────────────────────────────────────────");
        String[] named = {"사원번호", "이름", "직급", "기본급", "수당", "세율", "월급"};
        System.out.printf("|  %-6s|  %-4s|  %-3s|  %-9s|  %-7s|  %-6s   |  %-9s|", named[0], named[1], named[2], named[3],                      named[4], named[5], named[6]);
        System.out.println("\n──────────────────────────────────────────────────────────────────────────────");
       for(int i = 0 ; i < arr.size(); i++) {
            System.out.printf("|  %-6s  |  %-3s  |  %-4s|  %-8s  |  %-6d  |  %-4f |  %-8d |\n", arr.get(i).getEmployeeNumber(),       arr.get(i).getName(), arr.get(i).getJobRank(), arr.get(i).getBasicSalary(), arr.get(i).getBonus(), arr.get(i).getTaxRate(),       arr.get(i).getMonthSalary()); 
       }
    }
    

    // 연차휴가수당 
   @Override
   public void weeklyAllowance(int money, int time) {
      int minimumWage, workingHours;
          minimumWage = money;
          workingHours = time;
          System.out.println(minimumWage * workingHours);
   }

   // 휴일 수당 중 초과 근무 수당
   @Override
   public void specialPay(int money, int time) {
      int minimumWage, workingHours;
          double multiple = 1.5;
          minimumWage = money;
          workingHours = time;
          System.out.println((int)(minimumWage * multiple) * workingHours);
   }

   // 초과 근로 수당, 야간 수당, 특별 수당, 휴일 수당
   @Override
   public void overtimePay(int money, int time) {
       int minimumWage, workingHours;
          double multiple = 1.5;
          minimumWage = money;
          workingHours = time;
          System.out.println((int)(minimumWage * multiple) * workingHours);
   }
}