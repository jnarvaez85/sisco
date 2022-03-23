package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;
import seguridad.VTcontadores;

public class MenuDAO {
	
	
	
	// MOSTRAR DATOS DEL MENU	
	
	
		public static  LinkedList<VTmenu> datosMenu(int cod_rol) {
	    	LinkedList<VTmenu> menu = new LinkedList<VTmenu> ();
	    	
	    	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
						
	     
			try {
				con = conx.conectar();
				ps = con.prepareStatement("SELECT * FROM view_menu WHERE permiso=1 AND  cod_rol="+cod_rol);
				
				
				rs = ps.executeQuery();
	     
	            while (rs.next()) {
	            	
	            	VTmenu men = new VTmenu();
	            	
	            	men.setCod_modulo(rs.getInt("cod_modulo"));
	            	men.setCod_menu(rs.getInt("cod_menu"));
	            	men.setCod_rol(rs.getInt("cod_rol"));
	            	men.setCod_tipo_menu(rs.getInt("cod_tipo_menu"));
	            	men.setEstado_menu(rs.getInt("estado_menu"));
	            	men.setEstado_permiso(rs.getString("estado_permiso"));
	            	men.setIcon_menu(rs.getString("icon_menu"));
	            	men.setLink_menu(rs.getString("link_menu"));
	            	men.setMenu(rs.getString("menu"));
	            	men.setModulo(rs.getString("modulo"));
	            	men.setOpcion(rs.getString("opcion"));
	            	men.setPermiso(rs.getInt("permiso"));
	            	men.setRol(rs.getString("rol"));
	            	men.setTipo_menu(rs.getString("tipo_menu"));
	            	men.setCod_enlace(rs.getInt("cod_enlace"));
	            	men.setTipo_enlace(rs.getString("tipo_enlace"));
	            	
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
		
		
		// MOSTRAR DATOS DEL MENU	
				public static  LinkedList<VTmenu> opcionUsuarios(int cod_rol) {
			    	LinkedList<VTmenu> menu = new LinkedList<VTmenu> ();
			    	
			    	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
								
			     
					try {
						con = conx.conectar();
						ps = con.prepareStatement("SELECT * FROM view_menu WHERE cod_modulo=10 AND  cod_rol="+cod_rol);
						
						
						rs = ps.executeQuery();
			     
			            while (rs.next()) {
			            	
			            	VTmenu men = new VTmenu();
			            	
			            	men.setCod_modulo(rs.getInt("cod_modulo"));
			            	men.setCod_menu(rs.getInt("cod_menu"));
			            	men.setCod_rol(rs.getInt("cod_rol"));
			            	men.setCod_tipo_menu(rs.getInt("cod_tipo_menu"));
			            	men.setEstado_menu(rs.getInt("estado_menu"));
			            	men.setEstado_permiso(rs.getString("estado_permiso"));
			            	men.setIcon_menu(rs.getString("icon_menu"));
			            	men.setLink_menu(rs.getString("link_menu"));
			            	men.setMenu(rs.getString("menu"));
			            	men.setModulo(rs.getString("modulo"));
			            	men.setOpcion(rs.getString("opcion"));
			            	men.setPermiso(rs.getInt("permiso"));
			            	men.setRol(rs.getString("rol"));
			            	men.setTipo_menu(rs.getString("tipo_menu"));
			            	
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

				
				// MOSTRAR OPCIONES GENERALES DEL MENU	
				public static VTmenu menuGeneral(int cod_rol, int cod_menu){
					 
				 	MysqlConexion conx = new MysqlConexion();
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
				 
					VTmenu men = new VTmenu();
				  
				  try{
					  
					  con = conx.conectar();					
					  ps = con.prepareStatement("SELECT * FROM view_menu WHERE cod_rol="+cod_rol+" AND cod_menu="+cod_menu);
					  
					  rs=	ps.executeQuery();
				   
				 	while(rs.next()){
		            	men.setCod_modulo(rs.getInt("cod_modulo"));
		            	men.setCod_menu(rs.getInt("cod_menu"));
		            	men.setCod_rol(rs.getInt("cod_rol"));
		            	men.setCod_tipo_menu(rs.getInt("cod_tipo_menu"));
		            	men.setEstado_menu(rs.getInt("estado_menu"));
		            	men.setEstado_permiso(rs.getString("estado_permiso"));
		            	men.setIcon_menu(rs.getString("icon_menu"));
		            	men.setLink_menu(rs.getString("link_menu"));
		            	men.setMenu(rs.getString("menu"));
		            	men.setModulo(rs.getString("modulo"));
		            	men.setOpcion(rs.getString("opcion"));
		            	men.setPermiso(rs.getInt("permiso"));
		            	men.setRol(rs.getString("rol"));
		            	men.setTipo_menu(rs.getString("tipo_menu"));
		            	men.setCod_enlace(rs.getInt("cod_enlace"));
		            	men.setTipo_enlace(rs.getString("tipo_enlace"));
				   }
				  } catch (SQLException e) {
						System.out.println("Error  al mostrar los datos del del menu general" + e);
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
				return men;
				}
				
		

		
		
}
