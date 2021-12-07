package seguridad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MysqlConexion;

public class ContadoresDAO {
	
	
	// CONSULTAR CONTADOR	
		public static VTcontadores validarContador(int cod_persona){
		 
		 	MysqlConexion conx = new MysqlConexion();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		 
		 
			VTcontadores cont = new VTcontadores();
		  
		  try{
			  
			  con = conx.conectar();					
			  ps = con.prepareStatement("SELECT * FROM view_contadores WHERE cod_persona="+cod_persona);
			  
			  rs=	ps.executeQuery();
		   
		 	while(rs.next()){
				cont.setCod_persona(rs.getInt("cod_persona"));	
				cont.setCod_cont(rs.getInt("cod_cont"));
				cont.setCargo_cont(rs.getString("cargo_cont"));
				cont.setNom_contador(rs.getString("nombre_contador"));
				cont.setTipo_doc_persona(rs.getInt("tipo_doc_persona"));
				cont.setTipo_identificacion(rs.getString("tipo_identificacion"));
				cont.setDoc_persona(rs.getString("doc_persona"));
				cont.setDir_persona(rs.getString("dir_persona"));
				cont.setTel_persona(rs.getString("tel_persona"));
				cont.setCod_estado(rs.getInt("cod_estado"));
				cont.setEstado(rs.getString("estado"));
				cont.setTel_persona(rs.getString("tel_persona"));	
		   }
		  } catch (SQLException e) {
				System.out.println("Error al mostrar contador" + e);
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
		return cont;
		}
		
		
		
		// DESHABILITAR CONTADOR
		public static int deshabilitarContador(Contadores contador) throws SQLException {

			int rows = 0;
			
		 	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
	    	CallableStatement stmt = null;
	    	
			try {								
				
				con = conx.conectar();					
				String sql = "{call SP_DESHABILITA_CONTADOR (?,?,?,?,?,?)}";
		        stmt = con.prepareCall(sql);	
							
		        stmt.setInt(1, contador.getCod_persona());						        
		        stmt.setInt(2, contador.getCod_cont());
		        stmt.setString(3, contador.getCargo_cont());
		        stmt.setDate(4, (Date) contador.getFecha_inicio_con());
		        stmt.setDate(5, (Date) contador.getFecha_fin_con());
		        stmt.setInt(6, contador.getEstado_cont());
		
				

		        rows = stmt.executeUpdate();
				
			   } catch (SQLException e) {
					System.out.println("Error al deshabilitar contador " + e);
				}
	        
			finally {
				try {
					
					MysqlConexion.close(stmt);
					MysqlConexion.close(con);
				} catch (SQLException e) {
					System.out.println("Error al cerrar" + e);
				}
			}
			return rows;
		}

}
