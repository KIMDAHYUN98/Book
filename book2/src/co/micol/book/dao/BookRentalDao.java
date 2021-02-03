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

	public ArrayList<BookRentalVo> rentalSelectList() {
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo;

		String sql = "select * from t_bookreturn order by 1";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new BookRentalVo();
				vo.setRentaldate(rs.getDate("rentaldate"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setMemberid(rs.getString("memberid"));
				vo.setReturndate(rs.getString("returndate"));
				vo.setBcount(rs.getInt("bcount"));

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
	
	public int rentalInsert(BookRentalVo vo) {
		int n = 0;
		String sql = "INSERT INTO t_bookreturn(BOOKCODE, MEMBERID, RENTALDATE, BCOUNT) VALUES(?, ?, sysdate, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			psmt.setString(2, vo.getMemberid());
			psmt.setInt(3, vo.getBcount());
			
			n = psmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public int rentalUpdate(BookRentalVo vo) {
		int n = 0;
		String sql ="UPDATE t_bookreturn SET RETURNDATE = sysdate WHERE bookcode = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			
			n = psmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public int rentalDelete(BookRentalVo vo) {
		int n = 0;
		String sql = "delete from bookrental where bookcode = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
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
