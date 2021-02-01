package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookRentalDao;
import co.micol.book.dao.MemberDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class BookReturnForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// ¹Ý³³ ³»¿ª Æû ÀÌµ¿
		
		MemberDao dao = new MemberDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
			
		return "book/bookReturnForm";
	}

}
