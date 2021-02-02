package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BorrowBook implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setBookcode(request.getParameter("bookcode"));
		
		int n = dao.bookUpdate1(vo);
		
		String viewPage = "book/bookBorrowSuccess";
		
		if(n == 0) 
			viewPage = "book/bookBorrowFail";	
		
		return viewPage;
	}

}
