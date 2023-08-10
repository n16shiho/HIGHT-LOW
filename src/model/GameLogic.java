package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GameLogic {



	public boolean executeHight(HttpServletRequest request,
			HttpServletResponse response) {



		HttpSession session = request.getSession();
		Card card_0=(Card) session.getAttribute("card_0");
		Card card_1=(Card) session.getAttribute("card_1");

		System.out.println("最初のカードの数："+card_0.getNum());
		System.out.println("次のカードの数："+card_1.getNum());
		//ゲームの判定
		if(card_0.getNum() <=card_1.getNum()) {
			//アタリ
			return true;
		}else {
			//ハズレ
			return false;
		}

	}


	public boolean executeLow(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Card card_0=(Card) session.getAttribute("card_0");
		Card card_1=(Card) session.getAttribute("card_1");

		System.out.println("最初のカードの数："+card_0.getNum());
		System.out.println("次のカードの数："+card_1.getNum());

		//ゲームの判定
		if(card_0.getNum() >= card_1.getNum()) {
			//アタリ
			return true;
		}else {
			//ハズレ
			return false;
		}
	}




}
