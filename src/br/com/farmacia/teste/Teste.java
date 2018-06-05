package br.com.farmacia.teste;

import java.sql.Connection;

import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class Teste  {
	public static void main(String[] args)  {
		Connection connection = ConnectionFactory.getConnection();
		
	}

}
