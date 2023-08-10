package model;

import java.io.Serializable;

public class Card implements Serializable {
	//フィールド
	private String suit; //カードの記号
	private int num; //カードの数字

	//コンストラクタ
	public Card() {
		//処理なし
	}

	public Card(String suit, int num) {
	this.suit=suit;
	this.num=num;
	}

	public String getSuit() {
		return suit;
	}

	public int getNum() {
		return num;
	}







}
