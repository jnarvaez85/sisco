package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;
import seguridad.Personas;

public class PlanillasDAO {
	
	
	private static final String SELECT_DINERO = "SELECT * FROM tempo_planilla_dinero";

	
	
	// VALIDAR CUADRE
	public static int validarCuadre(TempoDineroPlanilla validar) throws SQLException {

		int rows = 0;
		
	 	MysqlConexion conx = new MysqlConexion();
    	Connection con = null;
    	CallableStatement stmt = null;
    	
		try {								
			
			con = conx.conectar();					
			String sql = "{call SP_VALIDAR_CUADRE (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	        stmt = con.prepareCall(sql);	
						
	        stmt.setInt(1, validar.getCod_planilla());						        
	        stmt.setInt(2, validar.getB_cien());
	        stmt.setInt(3, validar.getB_cincuenta());
	        stmt.setInt(4, validar.getB_veinte());
	        stmt.setInt(5, validar.getB_diez());
	        stmt.setInt(6, validar.getB_cinco());
	        stmt.setInt(7, validar.getB_dos());
	        stmt.setInt(8, validar.getB_mil());
	        stmt.setInt(9, validar.getM_mil());
	        stmt.setInt(10, validar.getM_quiniento());
	        stmt.setInt(11, validar.getM_dos());
	        stmt.setInt(12, validar.getM_cien());
	        stmt.setInt(13, validar.getM_cincuenta());
	        stmt.setInt(14, validar.getEstado());

	        rows = stmt.executeUpdate();
			
		   } catch (SQLException e) {
				System.out.println("Error al validar cuadre " + e);
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
	
	
	// LISTAR VALORES DINERO INGRESADO
				public static  LinkedList<TempoDineroPlanilla> listarDinero() {
			    	LinkedList<TempoDineroPlanilla> list_dinero = new LinkedList<TempoDineroPlanilla> ();
			    	
			    	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;	
			     
					try {
						con = conx.conectar();
						ps = con.prepareStatement(SELECT_DINERO);	
						rs = ps.executeQuery();
						
			            while (rs.next()) {
			            	
			            	TempoDineroPlanilla list_din = new TempoDineroPlanilla();
			            	
			            	list_din.setB_cien(rs.getInt("b_cien"));
			            	list_din.setB_cincuenta(rs.getInt("b_cincuenta"));
			            	list_din.setB_veinte(rs.getInt("b_veinte"));
			            	list_din.setB_diez(rs.getInt("b_diez"));	            	
			            	list_din.setB_cinco(rs.getInt("b_cinco"));
			            	list_din.setB_dos(rs.getInt("b_dos"));
			            	list_din.setB_mil(rs.getInt("b_mil"));
			            	list_din.setM_mil(rs.getInt("m_mil"));
			            	list_din.setM_quiniento(rs.getInt("m_quiniento"));
			            	list_din.setM_dos(rs.getInt("m_dos"));
			            	list_din.setM_cien(rs.getInt("m_cien"));
			            	list_din.setM_cincuenta(rs.getInt("m_cincuenta"));
			            	list_din.setEstado(rs.getInt("estado"));
			            	
			            	list_dinero.add(list_din);
			            }
			        } catch (SQLException e) {
						System.out.println("Error al mostrar listado de dinero " + e);
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
					
					return list_dinero;
				}
				
				
				// APROBAR PLANILLA
				public static int aprobarPlanilla(String nom_aprueba, int cod_estado_pla) throws SQLException {

					int rows = 0;
					
				 	MysqlConexion conx = new MysqlConexion();
			    	Connection con = null;
			    	CallableStatement stmt = null;
			    	
					try {								
						
						con = conx.conectar();					
						String sql = "{call SP_APRUEBA_PLANILLA (?,?)}";
				        stmt = con.prepareCall(sql);	
									
				        stmt.setString(1, nom_aprueba);						        
				        stmt.setInt(2, cod_estado_pla);
						

				        rows = stmt.executeUpdate();
						
					   } catch (SQLException e) {
							System.out.println("Error al Aprobar Planilla " + e);
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
