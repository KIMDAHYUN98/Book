package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.MemberVo;
import co.micol.common.DAO;

public class BookRentalDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<BookRentalVo> rentalSelectList() { // �룄�꽌 ��異�/諛섎궔 �쟾泥� �궡�뿭
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo;

		String sql = "SELECT * FROM BOOKRENTAL";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookRentalVo();
				vo.setRentaldate(rs.getDate("rentaldate"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setMemberid(rs.getString("memberid"));
				vo.setReturndate(rs.getString("returndate"));

				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public BookRentalVo rentalSelect(BookRentalVo vo) {
		String sql = "SELECT * FROM BOOKRENTAL WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberid());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo = new BookRentalVo();
				vo.setRentaldate(rs.getDate("rentaldate"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setMemberid(rs.getString("memberid"));
				vo.setReturndate(rs.getString("returndate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	public int rentalInsert(BookRentalVo vo) { // �룄�꽌 ��異� �븯湲�
		int n = 0;
		String sql = "INSERT INTO BOOKRENTAL(BOOKCODE, MEMBERID, RETURNDATE) VALUES(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			psmt.setString(2, vo.getMemberid());
			psmt.setString(3, vo.getReturndate());
			
			n = psmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public int rentalUpdate(BookRentalVo vo) { // 諛섎궔�씪�옄 �닔�젙
		int n = 0;
		String sql ="UPDATE BOOKRENTAL SET RETURNDATE = ? WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getReturndate());
			psmt.setString(2, vo.getMemberid());
			
			n = psmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
