package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Member;

public class MemberDao {
	
	// JDBC �ֿ� �������̽�, Ŭ����
		// 1. Connection : DB���� �������̽� [DriverManager Ŭ������ ����]
	
	// 1. �ʵ� 
		private Connection connection; // �����������̽� ����
		private PreparedStatement preparedStatement; // sql ���� �������̽� ����
		private ResultSet resultSet; // ���� ���� �������̽� ����
		// ���� Ŭ������ ��ü �����
		private static MemberDao memberDao = new MemberDao();
	// 2. ������
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		} catch (Exception e) {
			System.out.println("db��������");
		}
		
	}
	// 3. �޼ҵ�
	public static MemberDao getMemberDao () { return memberDao;}
	
	// ��� �޼ҵ�
	
	// ȸ������ �޼ҵ� [ �μ��� memberr��ü�� �޾� db�� �����ϴ� �޼ҵ�]
	public boolean signup(Member member) {
		// 1. SQL �ۼ� [SQL : DB ���۾� DML]
		String sql = "insert into member(m_id, m_password, m_name, m_email, m_point)" + "values(?, ?, ?, ?, ?)";
		
		// 2. SQL --> DB ����
		try {
		preparedStatement = connection.prepareStatement(sql);
		
		// 3. SQL ���� [ ? �� ������ �ֱ� ]
		preparedStatement.setString(1, member.getM_id()); // ù��° ?�� ������ �ֱ�
		preparedStatement.setString(2, member.getM_password()); // �ι�° ?�� ������ �ֱ�
		preparedStatement.setString(3, member.getM_name());
		preparedStatement.setString(4, member.getM_email());
		preparedStatement.setInt(5, member.getM_point());
		
		preparedStatement.executeUpdate();
		return true; // ���� ������ true ��ȯ
		}catch(Exception e) { }
		
		return false; // ���� ����
	}
	// �α��� �޼ҵ�
	public boolean login (String id, String password) {
		
		// 1. SQL �ۼ�
		String sql = "select * from member where m_id=? and m_password=?";
		// 2. SQL -> DB ����
		try {
			preparedStatement = connection.prepareStatement(sql);
			// 3. SQL ���� [ ? �� ���� �޼ҵ�� ���� �μ��� ?�� ���� ]
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			// 4. SQL ���� [ Querey : ����( �˻� ��� )
			resultSet = preparedStatement.executeQuery();
			// 5. SQL ���[ �˻��� ���� ]
			if(resultSet.next() ) { // ���� ����� ���� ������ ������ true
				return true; // �α��� ����
			}else {
				return false; // �α��� ����
			}
			
		} catch (SQLException e) {	}
		return false; // db ����
	}
	// ���̵� ã�� �޼ҵ�
	public String findid (String name, String email) {
		// SQL �ۼ�
		String sql = "select m_id from member where m_name=? and m_email=?";
		// SQL -> DB ����
		try {
			preparedStatement = connection.prepareStatement(sql);
			// SQL ����
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			// SQL ����
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				// �˻������ ������
				return resultSet.getString(1); // ����(�˻����)�� ù��° �ʵ带 ��ȯ
			}else
				return null;
		} catch (SQLException e) {}
		return null;//db ����
	}
	// �н����� ã�� �޼ҵ�
	public String findpassword (String id, String email) {
		// SQL �ۼ�
		String sql = "select m_password from member where m_id=? and m_email=?";
		// SQL -> DB ����
		try {
			preparedStatement = connection.prepareStatement(sql);
			// SQL ����
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, email);
			// SQL ����
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				// �˻������ ������
				return resultSet.getString(1); // ����(�˻����)�� ù��° �ʵ带 ��ȯ
			}else
				return null;
		} catch (SQLException e) {}
		return null;//db ����
	}
	// ȸ������ ���� �޼ҵ�
	
	// ȸ�� Ż�� �޼ҵ�
	
	public boolean delete(String loginid) {
		String sql = "delete from member where m_id=?";
						// delete from ���̺��
						// delete from ���̺�� where ���� 
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginid);
			preparedStatement.executeUpdate();
			return true; // ���� ������ true
		}catch (Exception e) {	}
		return false; // db ����
	}
	// ȸ����ȸ �޼ҵ� [ ȸ�� ���̵� �μ��� �޾� ȸ������ ��ȯ ]
	public Member getmember(String loginid) {
		
		// SQL �ۼ�
		String sql = "select * from member where m_id=?";
		// SQL ����
		try {
		preparedStatement = connection.prepareStatement(sql);
		// SQL ����
		preparedStatement.setString(1, loginid);
		// SQL ����
		resultSet = preparedStatement.executeQuery();
		// SQL ���
		if(resultSet.next()) {
			// �н����带 ������ ȸ������
			Member member = new Member(resultSet.getString(2), "", resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
			return member; // ã�� ������ ��ü�� ��ȯ
		}else {
			
		}
		}
		catch (Exception e) {}
		return null; // ȸ�������� �������
		
		
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// db ���� �׽�Ʈ
//	// 1. mysql ����̺� Ȯ��
//	public static void main(String[] args) {
//		
//		// 2. DB����
//		try {
//			Class.forName("com.musql.cj.jdbc.Driver");
//			System.out.println("1. ����̺� �������� ����");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306//javafx?serverTimezome=UTC" ,"root","1234");
//		System.out.println(" 2. db ���� ����");
//		} catch (Exception e) {
//			System.out.println(" db ���� ���� ");
//		}
//	}
//	
}
