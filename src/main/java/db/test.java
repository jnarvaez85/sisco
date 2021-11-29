package db;

import java.sql.SQLException;

public class test {
	

	public static void main(String[] args) throws SQLException {
		
		
		MysqlConexion c=new MysqlConexion();
		var result= c.conectar();
		
		if(result!=null) {
			System.out.print("La conexión se logro exitosamente");
		}else {
			System.out.print("Hubo un error en la conexión");
		}
		
	}
	
	

}
