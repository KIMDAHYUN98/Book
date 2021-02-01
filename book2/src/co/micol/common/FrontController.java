package co.micol.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.web.BookReturn;
import co.micol.book.web.BookReturnForm;
import co.micol.book.web.IdCheck;
import co.micol.book.web.Login;
import co.micol.book.web.LoginForm;
import co.micol.book.web.Logout;
import co.micol.book.web.MemberJoin;
import co.micol.book.web.MemberJoinForm;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainService());
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login()); // 濡쒓렇�씤 �샇異�
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼 이동
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/idCheck.do", new IdCheck()); // 아이디 중복체크
		map.put("/bookReturnForm.do", new BookReturnForm()); // 도서 반납 목록
		map.put("/bookReturn.do", new BookReturn());// 도서 반납
		map.put("/logout.do", new Logout()); // 로그 아웃
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // �떎�젣 �슂泥�.

		Command command = map.get(path); // �슂泥��븳 寃껋쓣 泥섎━�븯�뒗 command瑜� 李얠븘以��떎.
		String viewPage = command.excute(request, response); // 泥섎━�븳 �썑 寃곌낵瑜� �룎�젮以� Page 媛믪쓣 諛쏆쓬.

		if (!viewPage.endsWith(".do"))
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
