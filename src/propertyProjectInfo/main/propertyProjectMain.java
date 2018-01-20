package propertyProjectInfo.main;

import java.util.ArrayList;
import java.util.Scanner;

import propertyProjectInfo.dao.propertyProjectDAO;
import propertyProjectInfo.dto.propertyBasisInfo;
import propertyProjectInfo.dto.propertyProjectDetail;

public class propertyProjectMain {
	public static void main(String[] args) {
		//입력 (int)
		Scanner pl = new Scanner(System.in);
		//입력 (String)
		Scanner plStr = new Scanner(System.in);
		System.out.println("다음메뉴를 선택해주세요.");
		System.out.println("1.부동산 정보 보기 2.부동산 정보수정 3.부동산 정보 추가");
		int input = pl.nextInt();
		
		//dao 객체 인스턴스 생성
	
	  propertyProjectDAO dao = propertyProjectDAO.getInstance();
	  if(input == 1) {
	              ArrayList<propertyBasisInfo> list = dao.getPropertyBasisInfo();
	              // 출력
                 System.out.println(input+"부동산 정보 보기를 선택하셨습니다.");	
                 for(int i =0; i < list.size(); i++) {
                	 System.out.println(list.get(i).getpNumber()
                			 +","+list.get(i).getpType()
                			 +","+list.get(i).getpPrice()+"만원");
                	 System.out.println();
                 
                 }
                 System.out.println("더 상세정보를 보시겠습니까? (Y/N)");
                 String inputStr = plStr.nextLine();
                 ArrayList<propertyProjectDetail> result = dao.getpropertyProjectDetail();
                 if(inputStr.trim().equalsIgnoreCase("Y")) {
                	 for (int i = 0; i < result.size(); i++) {
                         System.out.print(result.get(i).getpNumber()+",");
                        System.out.print(result.get(i).getpDate()+",");
                        System.out.print(result.get(i).getpType()+",");
                        System.out.print(result.get(i).getpPosition()+",");
                        System.out.print(result.get(i).getpPrice()+"만원"+",");
                        System.out.print(result.get(i).getpObtain()+"만원"+",");
                        System.out.println();
                	 }   
                	 
                	
                 } else if(inputStr.trim().equalsIgnoreCase("N")) {
                	System.out.println("종료하겠습니다."); 
                 }
                 
	  } else if (input == 2){
		  System.out.println("2번을 선택하셨습니다");
		  ArrayList<propertyProjectDetail> result = dao.getpropertyProjectDetail();
		  for(int i =0; i < result.size(); i++) {
			  System.out.println(result.get(i).toString());
		  }
		  System.out.println("관리자 비밀번호를 입력하세요: ");
		  int inputPassword = pl.nextInt();
		  
		  if(inputPassword==1004) {
		  System.out.println("어떤 항목을 수정하시겠습니까? :");
		  int inputNum = pl.nextInt();
		  
		  //수정할 데이터들 검색
		  System.out.println("부동산 유형을 입력하세요 : ");
		  String pType = plStr.nextLine();
		  System.out.println("부동산 위치를 선택하세요: ");
		  String pPosition = plStr.nextLine();
		  System.out.println("부동산 가격을 선택하세요(만원): ");
		  int pPrice = pl.nextInt();
		  System.out.println("부동산 날짜를 입력하세요: ");
		  String pDate = plStr.nextLine(); 
		  System.out.println("부동산 시세차익을 입력하세요: ");
		  int pObtain = pl.nextInt();
		 //수정할 데이터 총 호출 
		 System.out.println(pDate);
		 System.out.println(pType);
		 System.out.println(pPosition);
		 System.out.println(pPrice);
		 System.out.println(pObtain);
		 //선택 항목 수정
		 dao.updatePropertyProjectDetail(inputNum, pType, pPosition, pPrice, pDate, pObtain);
		 
		 ArrayList<propertyProjectDetail> result2 = dao.getpropertyProjectDetail();
		 for (int i = 0; i < result2.size(); i++) {
			System.out.println(result2.get(i).toString());
			
		}
		  } else {
			  System.out.println("비밀번호가 틀렸습니다 종료하겠습니다");
		  }
		 System.out.println("======완료======");
		  
	  }else if(input ==3) {
		  System.out.println("정보추가를 하시겠습니까? (Y/N)");
		  String inputStr = plStr.nextLine(); 
		  if(inputStr.trim().equalsIgnoreCase("Y")) {
			  System.out.println("날짜 : ");
			  String propertyDate = plStr.nextLine(); 
			  System.out.println("부동산 유형 : ");
			  String propertyType = plStr.nextLine(); 
			  System.out.println("부동산 위치 : ");
			  String propertyLocation = plStr.nextLine();
			  System.out.println("부동산 가격 : ");
			  int provertyPrice = pl.nextInt();
			  System.out.println("부동산 시세차익: ");
			  int provertyObtain = pl.nextInt();
			  
			  dao.insertProvertyNewList(propertyDate,propertyType,
					                    propertyLocation,provertyPrice,provertyObtain);
			  
		  } else if(inputStr.trim().equalsIgnoreCase("N")) {
			  System.out.println("종료하겠습니다.");
		  }
	  }
				
	}
	
}
