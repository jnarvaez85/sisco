package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MysqlConexion;
import seguridad.Personas;

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
	 		tempDatosPlanilla.setCont_colabora(rs.getInt("cont_colabora"));
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
	
	
	
	// PREPARAR DATOS DE LA PLANILLA EN TEMPO_PLANILLAS
	public static int preparaDatosPlanilla(VTtempoDatosPlanilla tempo, int cursor) throws SQLException {

		int rows = 0;
		
	 	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
    	CallableStatement stmt = null;
    	
		try {								
			
			con = conx.conectar();					
			String sql = "{call SP_PREPARA_TMP_PLANILLA (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	        stmt = con.prepareCall(sql);
	        
	        stmt.setInt(1, tempo.getCod_temp_planilla());	
	        stmt.setInt(2, tempo.getCod_persona());
	        stmt.setString(3, tempo.getNom_contador());
	        stmt.setDate(4, (Date) tempo.getFecha_genera());
	        stmt.setDate(5, (Date) tempo.getFecha_planilla());
	        stmt.setInt(6, tempo.getCod_servicio());
	        stmt.setInt(7, tempo.getCont_colabora());
	        stmt.setString(8, tempo.getNom_servicio());
	        stmt.setString(9, tempo.getHora_servicio());
	        stmt.setInt(10, tempo.getCod_colabora1());
	        stmt.setString(11, tempo.getNom_colabora1());
	        stmt.setInt(12, tempo.getCod_colabora2());
	        stmt.setString(13, tempo.getNom_colabora2());
	        stmt.setInt(14, tempo.getCod_colabora3());
	        stmt.setString(15, tempo.getNom_colabora3());
	        stmt.setInt(16, cursor);
			

	        rows = stmt.executeUpdate();
			
		   } catch (SQLException e) {
				System.out.println("Error al preparar datos tmp de la planillas " + e);
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
	
	
	// ELIMINAR TEMPO PLANILLA	
				public static int eliminarTempoPlanilla(int cod_temp_planilla) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	

					try {
						con = conx.conectar();					

						String sql = "{call SP_ELIMINA_TEMPO_PLANILLA (?)}";
				        stmt = con.prepareCall(sql);						
				
				        stmt.setInt(1, cod_temp_planilla);
											
						rows = stmt.executeUpdate();
						
						
					   } catch (SQLException e) {
							System.out.println("Error al eliminar tempo planilla" + e);
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
				
				
				// ELIMINAR SERVICIO
				public static int eliminarServicio(int cod_servicio) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	

					try {
						con = conx.conectar();					

						String sql = "{call SP_ELIMINA_SERVICIO (?)}";
				        stmt = con.prepareCall(sql);						
				
				        stmt.setInt(1, cod_servicio);
											
						rows = stmt.executeUpdate();
						
						
					   } catch (SQLException e) {
							System.out.println("Error al eliminar servicio " + e);
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
				
				
				// MODIFICAR SERVICIO
				public static int modificarServicio(Servicios servicio) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	
					try {								
						
						con = conx.conectar();					
						String sql = "{call SP_MODIFICA_SERVICIO (?,?,?)}";
				        stmt = con.prepareCall(sql);	
									
				        stmt.setInt(1, servicio.getCod_servicio());						        
				        stmt.setString(2, servicio.getNom_servicio());
				        stmt.setString(3, servicio.getHora_servicio());
				   
						

				        rows = stmt.executeUpdate();
						
					   } catch (SQLException e) {
							System.out.println("Error al modificar servicio " + e);
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
