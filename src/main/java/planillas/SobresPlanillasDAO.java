package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;

public class SobresPlanillasDAO {
	
	private static final String VER_SOBRES = "SELECT * FROM view_temp_sobres_planilla";
	
	
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
	
	
	
	// SUMAR DIEZMOS
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
	
	
	// SUMAR OFRENDAS
	public static VTtempoSobresPlanilla sumarOfrendas(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumOfrendas = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(ofrendas) ofrendas from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumOfrendas.setOfrendas(rs.getInt("ofrendas"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar ofrendas " + e);
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
	return sumOfrendas;
	}
	
	
	// SUMAR NECESITADOS
	public static VTtempoSobresPlanilla sumarNecesitados(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumNecesitados = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(necesitados) necesitados from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumNecesitados.setNecesitados(rs.getInt("necesitados"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar necesitados " + e);
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
	return sumNecesitados;
	}
	
	
	// SUMAR MERCADOS
	public static VTtempoSobresPlanilla sumarMercados(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumMercados = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(mercados) mercados from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumMercados.setMercados(rs.getInt("mercados"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar mercados " + e);
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
	return sumMercados;
	}
	
	
	// SUMAR CONSTRUCCION
	public static VTtempoSobresPlanilla sumarConstruccion(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumConstru = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(construccion) construccion from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumConstru.setConstruccion(rs.getInt("construccion"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar construccion " + e);
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
	return sumConstru;
	}
	
	
	// SUMAR MISIONES
	public static VTtempoSobresPlanilla sumarMisiones(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumMisiones = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(misiones) misiones from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumMisiones.setMisiones(rs.getInt("misiones"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar misiones " + e);
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
	return sumMisiones;
	}
	
	
	
	// SUMAR OTROS
	public static VTtempoSobresPlanilla sumarOtros(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumOtros = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(otros) otros from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumOtros.setOtros(rs.getInt("otros"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar otros " + e);
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
	return sumOtros;
	}
	
	
	// SUMAR ESPECIALES
	public static VTtempoSobresPlanilla sumarEspeciales(){
	 
	 	MysqlConexion conx = new MysqlConexion();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;						 
	 
		VTtempoSobresPlanilla sumEspecial = new VTtempoSobresPlanilla();
	  
	  try{
		  
		  con = conx.conectar();					
		  ps = con.prepareStatement("select sum(especial) especial from view_temp_sobres_planilla");							  
		  rs=	ps.executeQuery();
	   
	 	while(rs.next()){
	 		sumEspecial.setEspecial(rs.getInt("especial"));	
	 	 	
	   }
	  } catch (SQLException e) {
			System.out.println("Error al sumar especial " + e);
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
	return sumEspecial;
	}
	
	
	
	
	// LISTAR SOBRES DE LA PLANILLA
				public static  LinkedList<VTtempoSobresPlanilla> listarSobres() {
			    	LinkedList<VTtempoSobresPlanilla> listar_sobres= new LinkedList<VTtempoSobresPlanilla> ();
			    	
			    	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;	
			     
					try {
						con = conx.conectar();
						ps = con.prepareStatement(VER_SOBRES);	
						rs = ps.executeQuery();
						
			            while (rs.next()) {
			            	
			            	VTtempoSobresPlanilla list_sobre = new VTtempoSobresPlanilla();
			            	
			            	list_sobre.setCod_sobre(rs.getInt("cod_sobre"));
			            	list_sobre.setFecha_planilla(rs.getDate("fecha_planilla"));
			            	list_sobre.setNom_servicio(rs.getString("nom_servicio"));
			            	list_sobre.setHora_servicio(rs.getString("hora_servicio"));
			            	list_sobre.setCod_persona(rs.getInt("cod_persona"));
			            	list_sobre.setNom_persona(rs.getString("nom_persona"));
			            	list_sobre.setDoc_persona(rs.getString("doc_persona"));
			            	list_sobre.setDiezmos(rs.getInt("diezmos"));
			            	list_sobre.setOfrendas(rs.getInt("ofrendas"));
			            	list_sobre.setNecesitados(rs.getInt("necesitados"));
			            	list_sobre.setMercados(rs.getInt("mercados"));
			            	list_sobre.setConstruccion(rs.getInt("construccion"));
			            	list_sobre.setMisiones(rs.getInt("misiones"));
			            	list_sobre.setOtros(rs.getInt("otros"));
			            	list_sobre.setEspecial(rs.getInt("especial"));
			            	list_sobre.setNom_contador(rs.getString("nom_contador"));
			            	list_sobre.setNom_colabora1(rs.getString("nom_colabora1"));
			            	list_sobre.setNom_colabora2(rs.getString("nom_colabora2"));
			            	list_sobre.setNom_colabora3(rs.getString("nom_colabora3"));
			            	listar_sobres.add(list_sobre);
			            }
			        } catch (SQLException e) {
						System.out.println("Error al listar sobres " + e);
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
					
					return listar_sobres;
				}
				
				
				// ELIMINAR SOBRE
				public static int eliminarSobre(int cod_sobre) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	

					try {
						con = conx.conectar();					

						String sql = "{call SP_ELIMINA_SOBRE (?)}";
				        stmt = con.prepareCall(sql);						
				
				        stmt.setInt(1, cod_sobre);
											
						rows = stmt.executeUpdate();
						
						
					   } catch (SQLException e) {
							System.out.println("Error al eliminar Sobre " + e);
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
				
				
				// COMPARTIR PLANILLA
				public static int compartirPlanilla(VTtempoDatosPlanilla compartir) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	
					try {								
						
						con = conx.conectar();					
						String sql = "{call SP_COMPARTIR_PLANILLA (?,?)}";
				        stmt = con.prepareCall(sql);	
									
				        stmt.setInt(1, compartir.getCod_temp_planilla());						        
				        stmt.setInt(2, compartir.getCompartida());
				   
						

				        rows = stmt.executeUpdate();
						
					   } catch (SQLException e) {
							System.out.println("Error al compartir planilla " + e);
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
				
				
				// FINALIZAR SOBRES
				public static int finalizarIngresos(VTtempoDatosPlanilla estado_planilla) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	
					try {								
						
						con = conx.conectar();					
						String sql = "{call SP_FINALIZAR_INGRESO (?,?)}";
				        stmt = con.prepareCall(sql);	
									
				        stmt.setInt(1, estado_planilla.getCod_temp_planilla());						        
				        stmt.setInt(2, estado_planilla.getEstado_planilla());
				   
						

				        rows = stmt.executeUpdate();
						
					   } catch (SQLException e) {
							System.out.println("Error al finalizar ingreso de sobres de planilla " + e);
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
