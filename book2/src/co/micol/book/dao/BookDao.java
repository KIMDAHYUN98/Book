package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.vo.BookVo;
import co.micol.common.DAO;

public class BookDao extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<BookVo> bookSelectList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo vo = new BookVo();

		String sql = "select * from book order by 1";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookVo();
				vo.setBookname(rs.getString("bookname"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setQuantity(rs.getInt("quantity"));
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

	public BookVo bookSelect(BookVo vo) {
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new BookVo();
				vo.setBookname(rs.getString("bookname"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setBcount(rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	public int bookInsert(BookVo vo) {
		int n = 0;
		String sql = "INSERT INTO BOOK (BOOKCODE, BOOKNAME) VALUES (?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			psmt.setString(2, vo.getBookname());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookUpdate1(BookVo vo) {
		int n = 0;
		String sql = "UPDATE BOOK SET BCOUNT = BCOUNT - 1 WHERE BOOKCODE = ?";

		try {
			if(vo.getBcount() > 0 && vo.getBcount() < 6) {
			System.out.println("현재 수량 : " + vo.getBcount());
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
				n = psmt.executeUpdate();
			} else {
				n = 0;
			}
			System.out.println("if문을 거친 현재 n의 수 : " + n);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookUpdate2(BookVo vo) {
		int n = 0;
		String sql = "UPDATE BOOK SET BCOUNT = BCOUNT + 1 WHERE BOOKCODE = ?";

		try {
			if (vo.getBcount() > 0 && vo.getBcount() < 6) {
				System.out.println("현재 수량 : " + vo.getBcount());
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getBookcode());
				n = psmt.executeUpdate();
			} else {
				n = 0;
			}
			System.out.println("if문을 거친 현재 n의 수 : " + n);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookUpdate(BookVo vo) {
		int n = 0;
		String sql = "UPDATE BOOK SET bookname = ? WHERE BOOKCODE = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookname());
			psmt.setString(2, vo.getBookcode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookDelete(BookVo vo) {
		int n = 0;
		String sql = "DELETE FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
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
