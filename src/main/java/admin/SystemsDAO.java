package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;

public class SystemsDAO {
	
	private static final String SELECT_SYS = "SELECT * FROM admin_sisco";
	
	// MOSTRAR DATOS DEL SISTEMA
	
		public static  LinkedList<Systems> datosSystema() {
	    	LinkedList<Systems> systems = new LinkedList<Systems> ();
	    	
	    	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;	
	     
			try {
				con = conx.conectar();
				ps = con.prepareStatement(SELECT_SYS);
				
				
				rs = ps.executeQuery();
	     
	            while (rs.next()) {
	            	
	            	Systems sys = new Systems();
	            	
	            	sys.setCod_sys(rs.getInt("cod_sys"));
	            	sys.setNom_sys(rs.getString("nom_sys"));
	            	sys.setVer_sys(rs.getString("ver_sys"));
	            	sys.setDesing_sys(rs.getString("desing_sys"));
	            	systems.add(sys);
	            }
	        } catch (SQLException e) {
				System.out.println("Error al mostrar los datos del systema " + e);
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
			
			return systems;
		}

}
