package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookEdit implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 수정 하기
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		vo.setBookname(request.getParameter("bookname"));
		
		int n = dao.bookUpdate(vo);
		String viewPage = "bookList.do";
		
		if(n == 0) {
			viewPage = "book/bookEditFail";
		}
		
		return viewPage;
	}

}
