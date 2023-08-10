package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterUser;
import model.RegisterUserLogic;

/**
 * Servlet implementation class RegisterUserSevlet
 */
@WebServlet("/RegisterUserSevlet")
public class RegisterUserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//フォワード
				RequestDispatcher dispatcher=
						request.getRequestDispatcher
						("/WEB-INF/jsp/registerUser.jsp");
				dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		//ユーザー登録情報の処理
		RegisterUser registerUser = new RegisterUser(userId, pass, mail, name, age);
		RegisterUserLogic bo = new RegisterUserLogic();
		boolean result = bo.execute(registerUser);



		//ユーザー登録の成否によって処理を分岐

		if(result) {
			//ユーザー登録成功時
			//ユーザー情報をリクエストスコープに保存
			request.setAttribute("registerUserId", registerUser);
			//フォワード
			RequestDispatcher dispatcher=
					request.getRequestDispatcher
					("/WEB-INF/jsp/registerUserOk.jsp");
			dispatcher.forward(request, response);
	}else{
		//リダイレクト
		response.sendRedirect("/highAndLow/RegisterUserSevlet");
	}

	}

}
