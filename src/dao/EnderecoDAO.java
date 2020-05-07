package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement; 

import config.ConFactory;
import model.Endereco;

public class EnderecoDAO {
	
	private final static String URL = "jdbc:mysql://localhost:3306/impacta?useSSL=false";
	private final static String NOME = "root";
	private final static String SENHA = "root";     
	private static Connection con;  
	private static PreparedStatement comando;
	
	public static void insert(Object obj){  
	      conectar();  
	      try {  
	    	  Endereco objEndereco = (Endereco) obj;
	          comando = con.prepareStatement("insert into TB_ENDERECO (codigo,logradouro,numero,complemento,cep,bairro,cidade,estado) " +
	                                         "values (?,?,?,?,?,?,?,?)");
	    		comando.setInt(1, objEndereco.getCodigo());
	    		comando.setString(2, objEndereco.getLogradouro());
	    		comando.setString(3, objEndereco.getNumero());
	    		comando.setString(4, objEndereco.getComplemento());
	    		comando.setString(5, objEndereco.getCEP());
	    		comando.setString(6, objEndereco.getBairro());
	    		comando.setString(7, objEndereco.getCidade());
	    		comando.setString(8, objEndereco.getEstado());
	    		comando.execute();  
	   	  

	 
	         System.out.println("O registro " + objEndereco.getLogradouro() + " foi inserido");  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao inserir endereco", e.getMessage());  
	      } finally {  
	         fechar();  
	      }  
	   }  
	  
	   private static void conectar() {  
	      try {  
	         con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);  
	      } catch (ClassNotFoundException e) {  
	         imprimeErro("Erro ao carregar o driver", e.getMessage());  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao conectar", e.getMessage());  
	      }  
	   }  
	  
	   private static void fechar() {  
	      try {  
	         comando.close();  
	         con.close();  
	      } catch (SQLException e) {  
	         imprimeErro("Erro ao fechar conexão", e.getMessage());  
	      }  
	   }  
	   
	   private static void imprimeErro (String erro, String mensagem) {
		   System.out.println (erro + "\n" + mensagem);
	   }
}