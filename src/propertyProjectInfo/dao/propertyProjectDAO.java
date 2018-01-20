package propertyProjectInfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import propertyProjectInfo.dto.propertyBasisInfo;
import propertyProjectInfo.dto.propertyProjectDetail;

public class propertyProjectDAO {
	private propertyProjectDAO() {}
	public static propertyProjectDAO getInstance() {
		return LazyHolder.INSTANCE;
	}
	public static class LazyHolder{
		private static final propertyProjectDAO INSTANCE = new propertyProjectDAO();
	}
	Connection conn = null;
    PreparedStatement pstmt = null;
	ResultSet rs = null;
	
 public ArrayList<propertyBasisInfo> getPropertyBasisInfo(){
	 ArrayList<propertyBasisInfo> list = new ArrayList<propertyBasisInfo>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// oracle DBMS로 접근하는 주소,계정ID,비번
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "java");
			// 쿼리문 문자열 준비
			String sql = "select * from propertyBasisInfo";
					
			// DBMS에 날릴 기존 준비한 쿼리문 문자열을 집어넣는다
			pstmt = conn.prepareStatement(sql);
			// 쿼리 실행 하여 나온 결과를 어디에 집어넣을까??? (ResultSet)
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				propertyBasisInfo info = new propertyBasisInfo();
				
				info.setpNumber(rs.getInt(1));
				info.setpType(rs.getString(2));
				info.setpPrice(rs.getInt(3));
				
				list.add(info);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
  }
 public ArrayList<propertyProjectDetail> getpropertyProjectDetail() {
	 ArrayList<propertyProjectDetail> result = new ArrayList<propertyProjectDetail>();
	 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// oracle DBMS로 접근하는 주소,계정ID,비번
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "java");
			// 쿼리문 문자열 준비
			String sql = "select * from propertyDetail";
					
			// DBMS에 날릴 기존 준비한 쿼리문 문자열을 집어넣는다
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행 하여 나온 결과를 어디에 집어넣을까??? (ResultSet)
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				propertyProjectDetail detail = new propertyProjectDetail();
				
				detail.setpNumber(rs.getInt(1));
				detail.setpDate(rs.getString(2));
				detail.setpType(rs.getString(3));
				detail.setpPosition(rs.getString(4));
				detail.setpPrice(rs.getInt(5));
				detail.setpObtain(rs.getInt(6));
				result.add(detail);
				 
				
			
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     return result;
	 
 }
public void updatePropertyProjectDetail(int inputNum, String pType, String pPosition, int pPrice, String pDate, int pObtain) {
	// TODO Auto-generated method stub
	 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// oracle DBMS로 접근하는 주소,계정ID,비번
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "java");
			// 쿼리문 문자열 준비
			String sql ="update propertyDetail  set plType = ?, plPosition =?, plPrice=?, plDate=?, plObtain=? \r\n" + 
					    "where plNumber = ?";
					
			    pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pType);
				pstmt.setString(2, pPosition);
				pstmt.setInt(3, pPrice);
				pstmt.setString(4, pDate);
				pstmt.setInt(5, pObtain);
				pstmt.setInt(6, inputNum);
				pstmt.executeUpdate();
				
				System.out.println("업데이트 완료");
				
				 
				
	 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
public void insertProvertyNewList(String propertyDate, String propertyType, String propertyLocation, int provertyPrice,
		int provertyObtain) {
	
	 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// oracle DBMS로 접근하는 주소,계정ID,비번
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "java");
			// 쿼리문 문자열 준비
			String sql ="insert into propertyDetail (plNumber,plDate,plType,plPosition,plPrice,plObtain )"
					+ "values (propertyDetail_seq_plNum.nextval, ?, ?, ?, ?, ?)";
					
			    pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, propertyDate);
				pstmt.setString(2, propertyType);
				pstmt.setString(3,  propertyLocation);
				pstmt.setInt(4, provertyPrice);
				pstmt.setInt(5, provertyObtain);
				//insert, update 쿼리 실행
				pstmt.executeUpdate();
				
				System.out.println("업데이트 완료");
				
				 
				
	 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
   }
}
