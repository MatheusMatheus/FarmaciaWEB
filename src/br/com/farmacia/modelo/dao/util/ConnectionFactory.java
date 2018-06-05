package br.com.farmacia.modelo.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	

	public static Connection getConnection() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("br.com.farmacia.modelo.dao.util.bd");
			String url = bundle.getString("mysql.url");
			String usuario = bundle.getString("mysql.usuario");
			String senha = bundle.getString("mysql.senha");
			Class.forName(bundle.getString("mysql.driver"));
			Connection connection = DriverManager.getConnection(url, usuario, senha);
			if(connection != null) {
				System.out.println("Conexão realizada");
				return connection;
			}
				
		} catch (SQLException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		return null;
	}
}
