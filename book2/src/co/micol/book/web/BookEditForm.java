package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookEditForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 수정하는 폼 이동
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		
		vo = dao.bookSelect(vo);
		
		request.setAttribute("vo", vo);
		
		return "book/bookEditForm";
	}

}
