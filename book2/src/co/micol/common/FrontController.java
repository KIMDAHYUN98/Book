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

import co.micol.book.web.BookEdit;
import co.micol.book.web.BookEditForm;
import co.micol.book.web.BookInsert;
import co.micol.book.web.BookInsertForm;
import co.micol.book.web.BookList;
import co.micol.book.web.BookReturn;
import co.micol.book.web.BookReturnForm;
import co.micol.book.web.BookView;
import co.micol.book.web.BorrowBook;
import co.micol.book.web.BorrowSetForm;
import co.micol.book.web.IdCheck;
import co.micol.book.web.Login;
import co.micol.book.web.LoginForm;
import co.micol.book.web.Logout;
import co.micol.book.web.MemberDelete;
import co.micol.book.web.MemberEdit;
import co.micol.book.web.MemberEditForm;
import co.micol.book.web.MemberInsert;
import co.micol.book.web.MemberInsertForm;
import co.micol.book.web.MemberJoin;
import co.micol.book.web.MemberJoinForm;
import co.micol.book.web.MemberSetForm;
import co.micol.book.web.bookDelete;

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
		map.put("/login.do", new Login()); // 로그인
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼 이동
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/idCheck.do", new IdCheck()); // 아이디 중복체크
		map.put("/bookReturnForm.do", new BookReturnForm()); // 도서 반납 목록
		map.put("/bookReturn.do", new BookReturn());// 도서 반납
		map.put("/logout.do", new Logout()); // 로그 아웃
		map.put("/bookList.do", new BookList()); // 대여할 도서 목록
		map.put("/borrowBook.do", new BorrowBook()); // 도서 대여
		map.put("/bookInsertForm.do", new BookInsertForm()); // 도서 등록 화면
		map.put("/bookInsert.do", new BookInsert()); // 도서 등록
		map.put("/bookView.do", new BookView()); // 도서 상세보기
		map.put("/bookEditForm.do", new BookEditForm()); // 도서 수정 폼
		map.put("/bookEdit.do", new BookEdit()); // 도서 수정하기
		map.put("/bookDelete.do", new bookDelete()); // 도서 삭제하기
		map.put("/memberSetForm.do", new MemberSetForm()); // 회원관리 폼 여기부터 생성하기!!
		map.put("/memberDelete.do", new MemberDelete()); //유저 삭제
		map.put("/memberEditForm.do", new MemberEditForm()); //유저 수정 폼
		map.put("/memberEdit.do", new MemberEdit()); //유저 수정
		map.put("/memberInsertForm.do", new MemberInsertForm()); //유저 등록 폼
		map.put("/memberInsert.do", new MemberInsert()); //유저 등록
		map.put("/borrowSetForm.do", new BorrowSetForm()); //대여 리스트 전체 보기 폼
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());

		Command command = map.get(path); 
		String viewPage = command.excute(request, response); 

		if (!viewPage.endsWith(".do"))
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
