package model;

import java.io.Serializable;

public class RegisterUser implements Serializable{
	private String userId; //ユーザーID
	private String pass;   //パスワード
	private String mail;   //メールアドレス
	private String name;   //名前
	private int age;      //年齢


	public RegisterUser(String userId, String pass,  String mail, String name, int age) {
		this.userId=userId;
		this.pass=pass;
		this.mail=mail;
		this.name=name;
		this.age=age;
	}


	public String getUserId() {
		return userId;
	}


	public String getPass() {
		return pass;
	}


	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}



	public int getAge() {
		return age;
	}





}
