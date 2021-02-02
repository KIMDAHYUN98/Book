package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class bookDelete implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 삭제하기
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		BookRentalDao rdao = new BookRentalDao();
		BookRentalVo rvo = new BookRentalVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		rvo.setBookcode(request.getParameter("bookcode"));
		
		int n = rdao.rentalDelete(rvo);
		n = dao.bookDelete(vo);
		
		String viewPage = "bookList.do";
		
		if(n == 0) {
			viewPage = "book/bookDeleteFail";
		}
		
		return viewPage;
	}

}
