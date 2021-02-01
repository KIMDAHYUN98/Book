package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.common.Command;

public class BookReturn implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납하기
		BookRentalDao dao = new BookRentalDao();
		BookRentalVo vo = new BookRentalVo();
		
		
		
		return "book/bookReturn";
	}

}
