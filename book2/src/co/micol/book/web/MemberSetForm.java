package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class MemberSetForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {

		MemberDao dao = new MemberDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		list = dao.selectList();
		
		request.setAttribute("list", list); 
		return "member/memberList";
	}

}
