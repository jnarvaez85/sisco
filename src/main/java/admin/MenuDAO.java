package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;

public class MenuDAO {
	
	private static final String SELECT_MENU = "SELECT * FROM admin_menu";
	
	// MOSTRAR DATOS DEL MENU
	
		public static  LinkedList<Menu> datosMenu() {
	    	LinkedList<Menu> menu = new LinkedList<Menu> ();
	    	
	    	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;	
	     
			try {
				con = conx.conectar();
				ps = con.prepareStatement(SELECT_MENU);
				
				
				rs = ps.executeQuery();
	     
	            while (rs.next()) {
	            	
	            	Menu men = new Menu();
	            	
	            	men.setCod_menu(rs.getInt("cod_menu"));
	            	men.setCod_menu_param(rs.getInt("cod_menu_param"));
	            	men.setNom_menu(rs.getString("nom_menu"));
	            	men.setIcon_menu(rs.getString("icon_menu"));
	            	men.setEstado_menu(rs.getInt("estado_menu"));
	            	men.setLink_menu(rs.getString("link_menu"));
	            	menu.add(men);
	            }
	        } catch (SQLException e) {
				System.out.println("Error al mostrar los datos del del menu " + e);
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
			
			return menu;
		}

		

		
		
}
