package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
	//フィールド
	private List<Card>stock = new ArrayList<>();  //山札


	//アクセサ
	public List<Card> getStock() {
		return stock;
	}


	public void setStock(List<Card> stock) {
		this.stock = stock;
	}


	//52枚のCardクラスのインスタンスを生成し、リストに追加する
	//スペード作成
	public void stock() {
		for(int i = 1; i<=13; i++) {
			stock.add(new Card("スペード",i));
		}
		//ハートの作成
		for(int i = 1; i<=13; i++) {
			stock.add(new Card("ハート",i));
		}
		//クローバーの作成
		for(int i = 1; i<=13; i++) {
			stock.add(new Card("クローバー",i));
		}
		//ダイヤ
		for(int i = 1; i<=13; i++) {
			stock.add(new Card("ダイヤ",i));
		}
	}


	 //山札をシャッフルする
	public void shuffleStock() {
		Collections.shuffle(stock);
	}

}
