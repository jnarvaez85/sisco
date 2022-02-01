package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import db.MysqlConexion;

public class SobresPlanillasDAO {
	
	
	// AGREGAR SOBRE	
	public void agregarSobre(TempoSobresPlanilla cod_sobre) throws SQLException {
		
    	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
		CallableStatement stmt = null;
		
		try {
			con = conx.conectar();
			
			 String sql = "{call SP_INSERT_SOBRE(?,?,?,?,?,?,?,?,?,?)}";
	         stmt = con.prepareCall(sql);
		
	         stmt.setInt(1, cod_sobre.getCod_sobre());
	         stmt.setInt(2, cod_sobre.getCod_persona());
	         stmt.setDouble(3, cod_sobre.getDiezmos());
	         stmt.setDouble(4, cod_sobre.getOfrendas());
	         stmt.setDouble(5, cod_sobre.getNecesitados());
	         stmt.setDouble(6, cod_sobre.getMercados());
	         stmt.setDouble(7, cod_sobre.getConstruccion());
	         stmt.setDouble(8, cod_sobre.getMisiones());
	         stmt.setDouble(9, cod_sobre.getOtros());
	         stmt.setDouble(10, cod_sobre.getEspecial());
	         
	         stmt.executeUpdate();
			
        } catch (SQLException e) {
				System.out.println("Error al agregar nuevo sobre " + e);
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

}
