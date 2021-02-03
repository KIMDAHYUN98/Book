package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BorrowBook implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		BookRentalDao rdao = new BookRentalDao();
		BookRentalVo rvo = new BookRentalVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		vo.setBcount(Integer.parseInt(request.getParameter("bcount")));
		rvo.setBcount(Integer.parseInt(request.getParameter("bcount")));
		rvo.setBookcode(request.getParameter("bookcode"));
		rvo.setMemberid(request.getParameter("memberid"));
		
		int n = dao.bookUpdate1(vo);
		System.out.println("대여 : " + n);
		
		if (n != 0) {		
		n = rdao.rentalInsert(rvo);
		}
		System.out.println("현재 수량 및 대여 : " + n);
		
		String viewPage;
		
		if(n == 0) {
			viewPage = "book/bookBorrowFail";	
		} else {
			viewPage = "book/bookBorrowSuccess";
		}
		
		return viewPage;
	}

}
