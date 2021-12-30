package seguridad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MysqlConexion;



public class PersonasDAO {
	
	MysqlConexion conx = new MysqlConexion();
	
	// CONSULTAR PERSONA
	
	@SuppressWarnings("static-access")
	public Personas consultarPersona(String segur_user) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stmt = null;

		Personas per = new Personas();

		try {

			conn = conx.conectar();
			
			String sql = "{call SP_VALIDA_PERSONA (?)}";
	        stmt = conn.prepareCall(sql);			
			
	        stmt.setString(1, segur_user);	    
			rs = stmt.executeQuery();

			while (rs.next()) {
		 		per.setCod_persona(rs.getInt("cod_persona"));	
		 		per.setNom_persona(rs.getString("nom_persona"));
		 		per.setTipo_doc_persona(rs.getInt("tipo_doc_persona"));
		 		per.setDoc_persona(rs.getString("doc_persona"));						 		
		 		per.setDir_persona(rs.getString("dir_persona"));
		 		per.setTel_persona(rs.getString("tel_persona"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			conx.close(rs);
			conx.close(stmt);
			conx.close(conn);
		}
		return per;
	}
	
	
	
	/*
	public Personas consultarPersona(String doc_persona){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		Personas per = new Personas();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("SELECT * FROM segur_persona WHERE doc_persona="+doc_persona);							  
		  
		  
	     ps.setString(1, doc_persona);
	     rs=	ps.executeQuery();
			

	   
	 	while(rs.next()){
	 		
	 		
	 		per.setCod_persona(rs.getInt("cod_persona"));	
	 		per.setNom_persona(rs.getString("nom_persona"));
	 		per.setTipo_doc_persona(rs.getInt("tipo_doc_persona"));
	 		per.setDoc_persona(rs.getString("doc_persona"));						 		
	 		per.setDir_persona(rs.getString("dir_persona"));
	 		per.setTel_persona(rs.getString("tel_persona"));
	 		
	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al consultar persona " + e);
		}
    
	finally {
		try {
			
			MysqlConexion.close(rs);
			MysqlConexion.close(ps);
			MysqlConexion.close(con);
		} catch (SQLException e) {
			System.out.println("Error al cerrar" + e);
		}
	}
	return per;
	}
*/
}
