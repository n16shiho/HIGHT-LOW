package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Card;
import model.Cards;
import model.GameLogic;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		Cards cards = new Cards();

		cards.stock();
		cards.shuffleStock();

		//山札から最初のカードを出す
		String suit_0 = cards.getStock().get(0).getSuit();
	    int num_0 = cards.getStock().get(0).getNum();

	    Card card_0 = new Card(suit_0, num_0);
	    System.out.println("最初のカード：" + suit_0 + num_0);
		HttpSession session = request.getSession();
		session.setAttribute("card_0", card_0);


		//山札から次のカードを出す
		String suit_1 = cards.getStock().get(1).getSuit();
	    int num_1 = cards.getStock().get(1).getNum();

	    Card card_1 = new Card(suit_1, num_1);
	    System.out.println("次のカード：" + suit_1 + num_1);
		session.setAttribute("card_1", card_1);


		RequestDispatcher dispatcher=
				request.getRequestDispatcher
				("/WEB-INF/jsp/game.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("state");
		String[] state = param.split(",");

		switch(state[0]) {
		//HIGHIT
		case "hight":
			procHight(request, response);
			break;
		//LOW
		case "low":
			procLow(request, response);
			break;
		}
	}

	/**
    * ゲーム結果画面に遷移する
    * <pre>
    * state属性＝"hight"時の処理
    * </pre>
    * @param request   HTTPのリクエスト
    * @param response  HTTPのレスポンス
    */
	private void procHight(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException,IOException {

		GameLogic gl = new GameLogic();

		if(gl.executeHight(request, response)) {

			HttpSession session = request.getSession();
			session.removeAttribute("card_0");


			RequestDispatcher dispatcher=
					request.getRequestDispatcher
					("/WEB-INF/jsp/gameWin.jsp");
			dispatcher.forward(request, response);
		}else {

			HttpSession session = request.getSession();
			session.removeAttribute("card_0");

			RequestDispatcher dispatcher=
					request.getRequestDispatcher
					("/WEB-INF/jsp/gameLose.jsp");
			dispatcher.forward(request, response);
		}
	}


	/**
	    * ゲーム結果画面に遷移する
	    * <pre>
	    * state属性＝"low"時の処理
	    * </pre>
	    * @param request   HTTPのリクエスト
	    * @param response  HTTPのレスポンス
	    */
		private void procLow(HttpServletRequest request,
				HttpServletResponse response)
				throws ServletException,IOException {

			GameLogic gl = new GameLogic();


			if(gl.executeLow(request, response)) {
				
				HttpSession session = request.getSession();
				session.removeAttribute("card_0");


				RequestDispatcher dispatcher=
						request.getRequestDispatcher
						("/WEB-INF/jsp/gameWin.jsp");
				dispatcher.forward(request, response);
			}else {
				
				HttpSession session = request.getSession();
				session.removeAttribute("card_0");


				RequestDispatcher dispatcher=
						request.getRequestDispatcher
						("/WEB-INF/jsp/gameLose.jsp");
				dispatcher.forward(request, response);
			}
		}






}
