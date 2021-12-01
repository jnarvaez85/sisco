package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;

public class ParametrosDAO {
	
	private static final String SELECT_PARAM = "SELECT * FROM admin_parametros";
	
	
	// MOSTRAR LISTA DE PARAMETROS
	public static  LinkedList<Parametros> listarParametros() {
    	LinkedList<Parametros> parametros = new LinkedList<Parametros> ();
    	
    	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
     
		try {
			con = conx.conectar();
			ps = con.prepareStatement(SELECT_PARAM);	
			rs = ps.executeQuery();
			
            while (rs.next()) {
            	
            	Parametros list_param = new Parametros();
            	
            	list_param.setCod_param(rs.getInt("cod_param"));
            	list_param.setNum_param(rs.getInt("num_param"));
            	list_param.setDetalle_param(rs.getString("detalle_param"));
            	parametros.add(list_param);
            }
        } catch (SQLException e) {
			System.out.println("Error al mostrar los parmaetros " + e);
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
		
		return parametros;
	}


}
