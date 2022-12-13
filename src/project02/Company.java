package project02;

public interface Company { //목차 역할
	   
	   //입력	   
	   public void saveWorker(); //직원 한명의 값 전달 메소드
	   public void saveWorker2();

	   //연산
	   public void modify(); //특정 직원의 직급,기본급,수당 수정 메소드
	   public void search(); //이름 값 으로 해당 값을 가진 직원 찾기 & 해당 값 출력 메소드
	   public void search2();

	   //출력
	   public void output(); //모든 직원의 정보 출력 메소드
	   
    // 연차휴가수당 
    public void weeklyAllowance();
   
    // 휴일 수당 중 초과 근무 수당
    public void overtimePay();
    
    //연차 개수 조회
    public void annualLeave();
    
    //퇴직금 및 연봉인상율 조회
    public void severancePay();
    
    //삭제
    public void delete();

}