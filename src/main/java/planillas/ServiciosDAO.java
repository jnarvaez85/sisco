package planillas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;

public class ServiciosDAO {
	
	private static final String SELECT_SERV= "SELECT * FROM planilla_servicios";
	
	
	// LISTAR NOMBRE DE COLABORADORES
			public static  LinkedList<Servicios> listarServicios() {
		    	LinkedList<Servicios> list_servicios= new LinkedList<Servicios> ();
		    	
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;	
		     
				try {
					con = conx.conectar();
					ps = con.prepareStatement(SELECT_SERV);	
					rs = ps.executeQuery();
					
		            while (rs.next()) {
		            	
		            	Servicios list_serv = new Servicios();
		            	
		            	list_serv.setCod_servicio(rs.getInt("cod_servicio"));
		            	list_serv.setNom_servicio(rs.getString("nom_servicio"));
		            	list_serv.setHora_servicio(rs.getString("hora_servicio"));		            		            	
		            	list_servicios.add(list_serv);
		            }
		        } catch (SQLException e) {
					System.out.println("Error al listar nombre de los servicios" + e);
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
				
				return list_servicios;
			}


}
