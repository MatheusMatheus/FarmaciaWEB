package br.com.farmacia.modelo.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionFactory {
	

	public static Connection getConnection() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("br.com.farmacia.modelo.dao.util.bd");
			Properties props = new Properties();
			props.put("user", bundle.getString("mysql.usuario"));
			props.put("password", bundle.getString("mysql.senha"));
			return DriverManager.getConnection(bundle.getString("mysql.url"), props);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
