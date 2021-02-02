package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookInsert implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 등록
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		vo.setBookname(request.getParameter("bookname"));
		
		int n = dao.bookInsert(vo);
		
		String viewPage = "bookList.do";
		
		if(n == 0) {
			
			viewPage = "book/bookInsertFail";
		}
		
		return viewPage;
	}

}
