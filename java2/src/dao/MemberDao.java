package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Member;

public class MemberDao {
	
	// JDBC 주요 인터페이스, 클래스
		// 1. Connection : DB연동 인터페이스 [DriverManager 클래스로 구현]
	
	// 1. 필드 
		private Connection connection; // 연결인터페이스 선언
		private PreparedStatement preparedStatement; // sql 연결 인터페이스 선언
		private ResultSet resultSet; // 쿼리 연결 인터페이스 선언
		// 현재 클래스내 객체 만들기
		private static MemberDao memberDao = new MemberDao();
	// 2. 생성자
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		} catch (Exception e) {
			System.out.println("db연동실패");
		}
		
	}
	// 3. 메소드
	public static MemberDao getMemberDao () { return memberDao;}
	
	// 기능 메소드
	
	// 회원가입 메소드 [ 인수로 memberr객체를 받아 db에 저장하는 메소드]
	public boolean signup(Member member) {
		// 1. SQL 작성 [SQL : DB 조작어 DML]
		String sql = "insert into member(m_id, m_password, m_name, m_email, m_point)" + "values(?, ?, ?, ?, ?)";
		
		// 2. SQL --> DB 연결
		try {
		preparedStatement = connection.prepareStatement(sql);
		
		// 3. SQL 설정 [ ? 에 데이터 넣기 ]
		preparedStatement.setString(1, member.getM_id()); // 첫번째 ?에 데이터 넣기
		preparedStatement.setString(2, member.getM_password()); // 두번째 ?에 데이터 넣기
		preparedStatement.setString(3, member.getM_name());
		preparedStatement.setString(4, member.getM_email());
		preparedStatement.setInt(5, member.getM_point());
		
		preparedStatement.executeUpdate();
		return true; // 저장 성공시 true 반환
		}catch(Exception e) { }
		
		return false; // 저장 실패
	}
	// 로그인 메소드
	public boolean login (String id, String password) {
		
		// 1. SQL 작성
		String sql = "select * from member where m_id=? and m_password=?";
		// 2. SQL -> DB 연결
		try {
			preparedStatement = connection.prepareStatement(sql);
			// 3. SQL 설정 [ ? 에 현재 메소드로 들어온 인수를 ?에 대입 ]
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			// 4. SQL 실행 [ Querey : 쿼리( 검색 결과 )
			resultSet = preparedStatement.executeQuery();
			// 5. SQL 결과[ 검색을 연결 ]
			if(resultSet.next() ) { // 쿼리 결과에 다음 내용이 있으면 true
				return true; // 로그인 성공
			}else {
				return false; // 로그인 실패
			}
			
		} catch (SQLException e) {	}
		return false; // db 오류
	}
	// 아이디 찾기 메소드
	public String findid (String name, String email) {
		// SQL 작성
		String sql = "select m_id from member where m_name=? and m_email=?";
		// SQL -> DB 연결
		try {
			preparedStatement = connection.prepareStatement(sql);
			// SQL 설정
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			// SQL 실행
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				// 검색결과가 있으면
				return resultSet.getString(1); // 쿼리(검색결과)내 첫번째 필드를 반환
			}else
				return null;
		} catch (SQLException e) {}
		return null;//db 오류
	}
	// 패스워드 찾기 메소드
	public String findpassword (String id, String email) {
		// SQL 작성
		String sql = "select m_password from member where m_id=? and m_email=?";
		// SQL -> DB 연결
		try {
			preparedStatement = connection.prepareStatement(sql);
			// SQL 설정
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, email);
			// SQL 실행
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				// 검색결과가 있으면
				return resultSet.getString(1); // 쿼리(검색결과)내 첫번째 필드를 반환
			}else
				return null;
		} catch (SQLException e) {}
		return null;//db 오류
	}
	// 회원정보 수정 메소드
	
	// 회원 탈퇴 메소드
	
	public boolean delete(String loginid) {
		String sql = "delete from member where m_id=?";
						// delete from 테이블명
						// delete from 테이블명 where 조건 
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginid);
			preparedStatement.executeUpdate();
			return true; // 삭제 성공시 true
		}catch (Exception e) {	}
		return false; // db 오류
	}
	// 회원조회 메소드 [ 회원 아이디를 인수로 받아 회원정보 반환 ]
	public Member getmember(String loginid) {
		
		// SQL 작성
		String sql = "select * from member where m_id=?";
		// SQL 연결
		try {
		preparedStatement = connection.prepareStatement(sql);
		// SQL 설정
		preparedStatement.setString(1, loginid);
		// SQL 실행
		resultSet = preparedStatement.executeQuery();
		// SQL 결과
		if(resultSet.next()) {
			// 패스워드를 제외한 회원정보
			Member member = new Member(resultSet.getString(2), "", resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
			return member; // 찾은 정보를 객체로 반환
		}else {
			
		}
		}
		catch (Exception e) {}
		return null; // 회원정보가 없을경우
		
		
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// db 연동 테스트
//	// 1. mysql 드라이브 확인
//	public static void main(String[] args) {
//		
//		// 2. DB연동
//		try {
//			Class.forName("com.musql.cj.jdbc.Driver");
//			System.out.println("1. 드라이브 가져오기 성공");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306//javafx?serverTimezome=UTC" ,"root","1234");
//		System.out.println(" 2. db 연동 성공");
//		} catch (Exception e) {
//			System.out.println(" db 연동 실패 ");
//		}
//	}
//	
}
