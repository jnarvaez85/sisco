package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import db.MysqlConexion;

public class EntidadDAO {
	
	private static final String SELECT_ENTIDAD = "SELECT * FROM admin_entidad";
	
	
	
	// MOSTRAR DATOS DE LA ENTIDAD
	public static  LinkedList<Entidad> datosEntidad() {
    	LinkedList<Entidad> entidad = new LinkedList<Entidad> ();
    	
    	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
     
		try {
			con = conx.conectar();
			ps = con.prepareStatement(SELECT_ENTIDAD);
			
			
			rs = ps.executeQuery();
     
            while (rs.next()) {
            	
            	Entidad ent = new Entidad();
            	
            	ent.setCod_entidad(rs.getInt("cod_entidad"));
            	ent.setNom_entidad(rs.getString("nom_entidad"));
            	ent.setNit_entidad(rs.getString("nit_entidad"));
            	ent.setDir_entidad(rs.getString("dir_entidad"));
            	ent.setTel_entidad(rs.getString("tel_entidad"));
            	ent.setOtro_entidad(rs.getString("otro_entidad"));
            	entidad.add(ent);
            }
        } catch (SQLException e) {
			System.out.println("Error al mostrar nombre de la entidad " + e);
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
		
		return entidad;
	}

}
