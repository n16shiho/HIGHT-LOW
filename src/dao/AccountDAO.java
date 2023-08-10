package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;
import model.RegisterUser;

public class AccountDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL=
			"jdbc:h2:tcp://localhost/~/highAndLow";
	private final String DB_USER="sa";
	private final String DB_PASS="";


	public Account findByLogin(Login login) {
		Account account=null;

		//データベースへ接続
		try(Connection conn=DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//SELECT文を準備
			String sql="SELECT USER_ID, PASS, MAIL, NAME, AGE "
					+ "FROM ACCOUNT "
					+ "WHERE USER_ID=? AND PASS=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs =pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if(rs.next()){
				//結果表からデータ取得
				String userId=rs.getString("USER_ID");
				String pass=rs.getString("PASS");
				String mail=rs.getString("MAIL");
				String name=rs.getString("NAME");
				int age=rs.getInt("AGE");

				account=new Account(userId, pass,  mail, name, age);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("検索失敗");
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}

	public boolean create(RegisterUser registerUser) {

		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//INSERT文の準備(idは自動連番なので指定しなくて良い)
			String sql="INSERT INTO ACCOUNT(USER_ID, PASS, MAIL, NAME, AGE) "
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt =conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を指定しSQLを完成
			pStmt.setString(1, registerUser.getUserId());
			pStmt.setString(2, registerUser.getPass());
			pStmt.setString(3, registerUser.getMail());
			pStmt.setString(4, registerUser.getName());
			pStmt.setInt(5, registerUser.getAge());

			//INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("追加失敗");
			return false;
		}
		return true;

	}

	public Account findBrUserId(RegisterUser registerUser) {
		Account account = null;

		//データベースへ接続
		try(Connection conn=DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)){
			//SELECT文を準備
			String sql="SELECT USER_ID, PASS, MAIL, NAME, AGE "
					+ "FROM ACCOUNT "
					+ "WHERE USER_ID=? AND PASS=? AND MAIL=? AND NAME=? AND AGE=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, registerUser.getUserId());
			pStmt.setString(2, registerUser.getPass());
			pStmt.setString(3, registerUser.getMail());
			pStmt.setString(4, registerUser.getName());
			pStmt.setInt(5, registerUser.getAge());

			//SELECT文を実行し、結果表を取得
			ResultSet rs =pStmt.executeQuery();

			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if(rs.next()){
				//結果表からデータ取得
				String userId=rs.getString("USER_ID");
				String pass=rs.getString("PASS");
				String mail=rs.getString("MAIL");
				String name=rs.getString("NAME");
				int age=rs.getInt("AGE");

				account=new Account(userId, pass,  mail, name, age);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("検索失敗");
			return null;
		}
		//見つかったユーザーまたはnullを返す
		return account;
	}


}
