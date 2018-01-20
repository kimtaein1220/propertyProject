package propertyProjectInfo.main;

import java.util.ArrayList;
import java.util.Scanner;

import propertyProjectInfo.dao.propertyProjectDAO;
import propertyProjectInfo.dto.propertyBasisInfo;
import propertyProjectInfo.dto.propertyProjectDetail;

public class propertyProjectMain {
	public static void main(String[] args) {
		//�Է� (int)
		Scanner pl = new Scanner(System.in);
		//�Է� (String)
		Scanner plStr = new Scanner(System.in);
		System.out.println("�����޴��� �������ּ���.");
		System.out.println("1.�ε��� ���� ���� 2.�ε��� �������� 3.�ε��� ���� �߰�");
		int input = pl.nextInt();
		
		//dao ��ü �ν��Ͻ� ����
	
	  propertyProjectDAO dao = propertyProjectDAO.getInstance();
	  if(input == 1) {
	              ArrayList<propertyBasisInfo> list = dao.getPropertyBasisInfo();
	              // ���
                 System.out.println(input+"�ε��� ���� ���⸦ �����ϼ̽��ϴ�.");	
                 for(int i =0; i < list.size(); i++) {
                	 System.out.println(list.get(i).getpNumber()
                			 +","+list.get(i).getpType()
                			 +","+list.get(i).getpPrice()+"����");
                	 System.out.println();
                 
                 }
                 System.out.println("�� �������� ���ðڽ��ϱ�? (Y/N)");
                 String inputStr = plStr.nextLine();
                 ArrayList<propertyProjectDetail> result = dao.getpropertyProjectDetail();
                 if(inputStr.trim().equalsIgnoreCase("Y")) {
                	 for (int i = 0; i < result.size(); i++) {
                         System.out.print(result.get(i).getpNumber()+",");
                        System.out.print(result.get(i).getpDate()+",");
                        System.out.print(result.get(i).getpType()+",");
                        System.out.print(result.get(i).getpPosition()+",");
                        System.out.print(result.get(i).getpPrice()+"����"+",");
                        System.out.print(result.get(i).getpObtain()+"����"+",");
                        System.out.println();
                	 }   
                	 
                	
                 } else if(inputStr.trim().equalsIgnoreCase("N")) {
                	System.out.println("�����ϰڽ��ϴ�."); 
                 }
                 
	  } else if (input == 2){
		  System.out.println("2���� �����ϼ̽��ϴ�");
		  ArrayList<propertyProjectDetail> result = dao.getpropertyProjectDetail();
		  for(int i =0; i < result.size(); i++) {
			  System.out.println(result.get(i).toString());
		  }
		  System.out.println("������ ��й�ȣ�� �Է��ϼ���: ");
		  int inputPassword = pl.nextInt();
		  
		  if(inputPassword==1004) {
		  System.out.println("� �׸��� �����Ͻðڽ��ϱ�? :");
		  int inputNum = pl.nextInt();
		  
		  //������ �����͵� �˻�
		  System.out.println("�ε��� ������ �Է��ϼ��� : ");
		  String pType = plStr.nextLine();
		  System.out.println("�ε��� ��ġ�� �����ϼ���: ");
		  String pPosition = plStr.nextLine();
		  System.out.println("�ε��� ������ �����ϼ���(����): ");
		  int pPrice = pl.nextInt();
		  System.out.println("�ε��� ��¥�� �Է��ϼ���: ");
		  String pDate = plStr.nextLine(); 
		  System.out.println("�ε��� �ü������� �Է��ϼ���: ");
		  int pObtain = pl.nextInt();
		 //������ ������ �� ȣ�� 
		 System.out.println(pDate);
		 System.out.println(pType);
		 System.out.println(pPosition);
		 System.out.println(pPrice);
		 System.out.println(pObtain);
		 //���� �׸� ����
		 dao.updatePropertyProjectDetail(inputNum, pType, pPosition, pPrice, pDate, pObtain);
		 
		 ArrayList<propertyProjectDetail> result2 = dao.getpropertyProjectDetail();
		 for (int i = 0; i < result2.size(); i++) {
			System.out.println(result2.get(i).toString());
			
		}
		  } else {
			  System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ� �����ϰڽ��ϴ�");
		  }
		 System.out.println("======�Ϸ�======");
		  
	  }else if(input ==3) {
		  System.out.println("�����߰��� �Ͻðڽ��ϱ�? (Y/N)");
		  String inputStr = plStr.nextLine(); 
		  if(inputStr.trim().equalsIgnoreCase("Y")) {
			  System.out.println("��¥ : ");
			  String propertyDate = plStr.nextLine(); 
			  System.out.println("�ε��� ���� : ");
			  String propertyType = plStr.nextLine(); 
			  System.out.println("�ε��� ��ġ : ");
			  String propertyLocation = plStr.nextLine();
			  System.out.println("�ε��� ���� : ");
			  int provertyPrice = pl.nextInt();
			  System.out.println("�ε��� �ü�����: ");
			  int provertyObtain = pl.nextInt();
			  
			  dao.insertProvertyNewList(propertyDate,propertyType,
					                    propertyLocation,provertyPrice,provertyObtain);
			  
		  } else if(inputStr.trim().equalsIgnoreCase("N")) {
			  System.out.println("�����ϰڽ��ϴ�.");
		  }
	  }
				
	}
	
}
