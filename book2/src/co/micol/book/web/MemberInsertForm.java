package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class MemberInsertForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		return "member/memberForm";
	}

}
