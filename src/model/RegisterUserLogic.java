package model;

import dao.AccountDAO;

public class RegisterUserLogic {

	public boolean execute(RegisterUser registerUser) {


		//AccountDAOインスタンスの生成し、
		//create()を呼ぶ
		AccountDAO dao=new AccountDAO();
		if(dao.create(registerUser)==false) {
			System.out.println("追加失敗");
		}
		Account account = dao.findBrUserId(registerUser);
		return account !=null ;
	}


}
