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
			
			String sql = "{call SP_CONSULTA_PERSONA (?)}";
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
	
	
	// INSERTAR USUARIO		
	public void agregarPersona(Personas persona) throws SQLException {
		
    	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
		CallableStatement stmt = null;
		
		try {
			con = conx.conectar();
			
			 String sql = "{call SP_INSERT_PERSONA (?,?,?,?,?)}";
	         stmt = con.prepareCall(sql);
		
	         stmt.setString(1, persona.getNom_persona());		         
	         stmt.setInt(2, persona.getTipo_doc_persona());
	         stmt.setString(3, persona.getDoc_persona());
	         stmt.setString(4, persona.getDir_persona());
	         stmt.setString(5, persona.getTel_persona());
	         stmt.executeUpdate();
			
        } catch (SQLException e) {
				System.out.println("Error al agregar persona " + e);
			}
			
			finally {
				try {
					
					MysqlConexion.close(stmt);
					MysqlConexion.close(con);
				} catch (SQLException e) {
					System.out.println("Error al cerrar" + e);
				}
			}
	}
	
	
	// VALIDAR PERSONA
	public int validarPersona(String usuario) {
		
	 	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
    	CallableStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = conx.conectar();			
			
			 String sql = "{call SP_VALIDA_PERSONA (?)}";
	         stmt = con.prepareCall(sql);			

	         stmt.setString(1, usuario);					
			 rs=	stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			MysqlConexion.close(rs);
			MysqlConexion.close(stmt);
			MysqlConexion.close(con);
			return 1;
			
		   } catch (SQLException e) {
				System.out.println("Error al validar persona " + e);
			}
        
		finally {
			try {
				
				MysqlConexion.close(rs);
				MysqlConexion.close(stmt);
				MysqlConexion.close(con);
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e);
			}
		}
		return 1;
	}
	
	
	
	
}
