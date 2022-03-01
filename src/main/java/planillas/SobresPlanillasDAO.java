package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MysqlConexion;

public class SobresPlanillasDAO {
	
	
	// AGREGAR SOBRE	
	public void agregarSobre(String nom_persona, TempoSobresPlanilla sobres) throws SQLException {
		
    	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
		CallableStatement stmt = null;
		
		try {
			con = conx.conectar();
			
			 String sql = "{call SP_INSERT_SOBRE(?,?,?,?,?,?,?,?)}";
	         stmt = con.prepareCall(sql);
		
	         stmt.setString(1, nom_persona);
	         stmt.setInt(2, sobres.getDiezmos());
	         stmt.setInt(3, sobres.getOfrendas());
	         stmt.setInt(4, sobres.getNecesitados());
	         stmt.setInt(5, sobres.getMercados());
	         stmt.setInt(6, sobres.getConstruccion());
	         stmt.setInt(7, sobres.getMisiones());
	         stmt.setInt(8, sobres.getOtros());
	         
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
	
	
	
	// CONTAR SOBRES PLANILLA
	public static VTtempoSobresPlanilla contarSobres(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla cantSobres = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select count(cod_sobre) cod_sobre from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		cantSobres.setCod_sobre(rs.getInt("cod_sobre"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al contar cantidad de sobres " + e);
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
	return cantSobres;
	}
	
	
	
	// SUMA DIEZMOS
	public static VTtempoSobresPlanilla sumarDiezmos(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumDiezmos = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(diezmos) diezmos from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumDiezmos.setDiezmos(rs.getInt("diezmos"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar diezmos " + e);
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
	return sumDiezmos;
	}

}
