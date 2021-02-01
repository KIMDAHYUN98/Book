package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class Login implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberid(request.getParameter("memberid"));
		vo.setMemberpassword(request.getParameter("memberpassword"));
		
		
		vo = dao.login(vo);
		
		String viewPage = null;
		
		
		if(vo.getMembermauth() != null) {
			HttpSession session= request.getSession(); 
			session.setAttribute("memberid", vo.getMemberid()); 
			session.setAttribute("membermauth", vo.getMembermauth()); 
			request.setAttribute("vo", vo);
			viewPage = "member/loginSuccess";
		}else {
			viewPage = "member/loginFail";
		}
		return viewPage;
	}


}
