package project02;
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class EzenCompony implements Company {
    ArrayList<CompanyBasics> arr = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    @Override
    public void saveWorker() {
        String name;
        String jobRank;
        int basicSalary;
        int bonus;
        double taxRate;
        int monthSalary;
        CompanyBasics cb = new CompanyBasics();
        System.out.print("사원 이름 : ");
        name = input.next();
        System.out.print("직급 : ");
        jobRank = input.next();
        System.out.println("기본급 : ");
        basicSalary = input.nextInt();
        System.out.println("수당 : ");
        bonus = input.nextInt();
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
    public void modify() {//수정
        System.out.println("수정할 사원의 이름을 입력 하세요 : ");
        String yourName = input.next();
        boolean flag = true;
        for (int i = 0 ; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(yourName)) {
                flag = false;
                System.out.println("직급 변경 입력 : ");
                String modiJobRank = input.next();
                arr.get(i).setJobRank(modiJobRank);
                System.out.println("기본급 변경 입력 : ");
                int modiSalary = input.nextInt();
                arr.get(i).setBasicSalary(modiSalary);
                System.out.println("수당 변경 입력 : ");
                int modiBounus = input.nextInt();
                arr.get(i).setBonus(modiBounus);
                System.out.println("수정이 정상적으로 완료되었습니다.");
                break;
            }
        }
        if (flag) {
            System.out.println("해당 사원이 없습니다.");
        }
        
    }
    @Override
    public void search() {
        System.out.print("찾고자하는 사원 이름을 입력하세요 : ");
        String yourName = input.next();
        boolean flag = true;
        for (int i = 0 ; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(yourName)) {
                flag = false;
                System.out.println("이름 : "+arr.get(i).getName());
                System.out.println("직급 : "+arr.get(i).getJobRank());
                System.out.println("기본급 : "+arr.get(i).getBasicSalary());
                System.out.println("수당 : "+arr.get(i).getBonus());
                System.out.println("세율 : "+arr.get(i).getTaxRate());
                System.out.println("월급 : "+arr.get(i).getMonthSalary());
                break;
            }
        }
        if (flag) {
            System.out.println("해당 사원이 없습니다.");
        }
    }
    @Override
    public void outputTitle() {
            
    }
    @Override
    public void output() {
        System.out.println("==========모든 사원 정보 출력==========");
        System.out.println("--------------------------------------------------");
        System.out.println("| 이름  | 직급 |   기본급   |   수당   |  세율  |   월급     |");
        System.out.println("--------------------------------------------------");
        for(int i = 0 ; i < arr.size(); i++) {
            System.out.println("|"+arr.get(i).getName()+"| "+arr.get(i).getJobRank()
                    +" | "+arr.get(i).getBasicSalary()+"  | "+arr.get(i).getBonus()
                    +" | "+arr.get(i).getTaxRate()+" | "+arr.get(i).getMonthSalary()+" |");
        }
    }
}

