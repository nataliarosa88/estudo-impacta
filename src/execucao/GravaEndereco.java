package execucao;

import dao.EnderecoDAO;
import model.Endereco;

public class GravaEndereco {  
   public static void main(String[] args) {
	   for( int i=1; i<=50; i++) {
		   EnderecoDAO.insert(new Endereco("rua numero " + i));      
	   }
   }
} 
