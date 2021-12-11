package planillas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MysqlConexion;

public class TempoDatosPlanillaDAO {
	
	
	
	
	// CONSULTAR DATOS TEMPORALES QUE PREPARA LA PLANILLA	
	public static VTtempoDatosPlanilla consultarDatosPlanillaTemp(int cod_temp_planilla){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoDatosPlanilla tempDatosPlanilla = new VTtempoDatosPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("SELECT DISTINCT * FROM view_temp_datos_planilla WHERE cod_temp_planilla="+cod_temp_planilla);							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		tempDatosPlanilla.setCod_temp_planilla(rs.getInt("cod_temp_planilla"));	
	 		tempDatosPlanilla.setCod_persona(rs.getInt("cod_persona"));
	 		tempDatosPlanilla.setNom_contador(rs.getString("nom_contador"));
	 		tempDatosPlanilla.setFecha_genera(rs.getDate("fecha_genera"));
	 		tempDatosPlanilla.setFecha_planilla(rs.getDate("fecha_planilla"));
	 		tempDatosPlanilla.setCod_servicio(rs.getInt("cod_servicio"));
	 		tempDatosPlanilla.setNom_servicio(rs.getString("nom_servicio"));
	 		tempDatosPlanilla.setHora_servicio(rs.getString("hora_servicio"));
	 		tempDatosPlanilla.setCod_colabora1(rs.getInt("cod_colabora1"));
	 		tempDatosPlanilla.setNom_colabora1(rs.getString("nom_colabora1"));
	 		tempDatosPlanilla.setCod_colabora2(rs.getInt("cod_colabora2"));
	 		tempDatosPlanilla.setNom_colabora2(rs.getString("nom_colabora2"));
	 		tempDatosPlanilla.setCod_colabora3(rs.getInt("cod_colabora3"));
	 		tempDatosPlanilla.setNom_colabora3(rs.getString("nom_colabora3"));
	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al consultar datos temporales de la planilla" + e);
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
	return tempDatosPlanilla;
	}

}
