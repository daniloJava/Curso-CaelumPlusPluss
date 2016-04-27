package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para para conexão com o BD
 * 
 * @author Danilo Silva
 * 
 */
public class ConnectionFactory {

	/**
	 * Metodos de pegar conexão.
	 * 
	 * @return conexão
	 * @throws SQLException
	 */

	public Connection getConnection() throws SQLException {
		System.out.println("conectando ...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		//return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");

		 return DriverManager.getConnection("jdbc:mysql://127.7.194.130/fj21",
		 "adminIBgjMpe", "sk35ZmnJCWk3");
	}

}
