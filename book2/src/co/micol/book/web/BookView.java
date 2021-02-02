package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookView implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 상세보기
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		
		vo = dao.bookSelect(vo);
		
		request.setAttribute("vo", vo);
		
		return "book/bookView";
	}

}
