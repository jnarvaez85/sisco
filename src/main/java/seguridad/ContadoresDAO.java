package seguridad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;

public class ContadoresDAO {
	
	private static final String SELECT_CONTADORES = "SELECT * FROM view_contadores";
	
	
	// LISTAR CONTADORES
			public static  LinkedList<VTcontadores> listarContadores() {
		    	LinkedList<VTcontadores> list_contadores = new LinkedList<VTcontadores> ();
		    	
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;	
		     
				try {
					con = conx.conectar();
					ps = con.prepareStatement(SELECT_CONTADORES);	
					rs = ps.executeQuery();
					
		            while (rs.next()) {
		            	
		            	VTcontadores list_cont = new VTcontadores();
		            	
		            	list_cont.setCod_persona(rs.getInt("cod_persona"));	
		            	list_cont.setCod_cont(rs.getString("cod_cont"));
		            	list_cont.setCargo_cont(rs.getString("cargo_cont"));
		            	list_cont.setFecha_inicio_con(rs.getDate("fecha_inicio_cont"));
		            	list_cont.setFecha_fin_con(rs.getDate("fecha_fin_cont"));
		            	list_cont.setNom_contador(rs.getString("nombre_contador"));
		            	list_cont.setTipo_doc_persona(rs.getInt("tipo_doc_persona"));
		            	list_cont.setTipo_identificacion(rs.getString("tipo_identificacion"));
		            	list_cont.setDoc_persona(rs.getString("doc_persona"));
		            	list_cont.setDir_persona(rs.getString("dir_persona"));
		            	list_cont.setTel_persona(rs.getString("tel_persona"));
		            	list_cont.setCod_estado(rs.getInt("cod_estado"));
		            	list_cont.setEstado(rs.getString("estado"));
		            	list_contadores.add(list_cont);
		            }
		        } catch (SQLException e) {
					System.out.println("Error al listar los contadores " + e);
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
				
				return list_contadores;
			}
			
	
	
	// CONSULTAR CONTADOR	
		public static VTcontadores validarContador(int cod_persona){
		 
		 	MysqlConexion conx = new MysqlConexion();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		 
		 
			VTcontadores cont = new VTcontadores();
		  
		  try{
			  
			  con = conx.conectar();					
			  ps = con.prepareStatement("SELECT * FROM view_contadores WHERE cod_persona="+cod_persona);
			  
			  rs=	ps.executeQuery();
		   
		 	while(rs.next()){
				cont.setCod_persona(rs.getInt("cod_persona"));	
				cont.setCod_cont(rs.getString("cod_cont"));
				cont.setCargo_cont(rs.getString("cargo_cont"));
				cont.setNom_contador(rs.getString("nombre_contador"));
				cont.setTipo_doc_persona(rs.getInt("tipo_doc_persona"));
				cont.setTipo_identificacion(rs.getString("tipo_identificacion"));
				cont.setDoc_persona(rs.getString("doc_persona"));
				cont.setDir_persona(rs.getString("dir_persona"));
				cont.setTel_persona(rs.getString("tel_persona"));
				cont.setCod_estado(rs.getInt("cod_estado"));
				cont.setEstado(rs.getString("estado"));					
		   }
		  } catch (SQLException e) {
				System.out.println("Error al mostrar contador" + e);
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
		return cont;
		}
		
		
		
		// DESHABILITAR CONTADOR
		public static int deshabilitarContador(Contadores contador) throws SQLException {

			int rows = 0;
			
		 	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
	    	CallableStatement stmt = null;
	    	
			try {								
				
				con = conx.conectar();					
				String sql = "{call SP_DESHABILITA_CONTADOR (?,?,?,?,?,?)}";
		        stmt = con.prepareCall(sql);	
							
		        stmt.setInt(1, contador.getCod_persona());						        
		        stmt.setString(2, contador.getCod_cont());
		        stmt.setString(3, contador.getCargo_cont());
		        stmt.setDate(4, (Date) contador.getFecha_inicio_con());
		        stmt.setDate(5, (Date) contador.getFecha_fin_con());
		        stmt.setInt(6, contador.getEstado_cont());
		
				

		        rows = stmt.executeUpdate();
				
			   } catch (SQLException e) {
					System.out.println("Error al deshabilitar contador " + e);
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
		
		
		// HABILITAR CONTADOR
		public static int habilitarContador(Contadores cont,  String cod_cont) throws SQLException {

			int rows = 0;
			
		 	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
	    	CallableStatement stmt = null;
	    	
			try {								
				
				con = conx.conectar();					
				String sql = "{call SP_HABILITA_CONTADOR (?,?,?,?,?,?)}";
		        stmt = con.prepareCall(sql);	
							
		        stmt.setInt(1, cont.getCod_persona());						        
		        stmt.setString(2, cod_cont);
		        stmt.setString(3, cont.getCargo_cont());
		        stmt.setDate(4, (Date) cont.getFecha_inicio_con());
		        stmt.setDate(5, (Date) cont.getFecha_fin_con());
		        stmt.setInt(6, cont.getEstado_cont());

		        rows = stmt.executeUpdate();
				
			   } catch (SQLException e) {
					System.out.println("Error al habilitar contador " + e);
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
		
		
		// VALIDAR CONTADOR
		@SuppressWarnings("static-access")
		public Contadores validarContador(int cod_persona, String cod_cont) throws SQLException {
			
			MysqlConexion conx = new MysqlConexion();
			Connection conn = null;
			ResultSet rs = null;
			CallableStatement stmt = null;

			Contadores cont = new Contadores();

			try {

				conn = conx.conectar();
				
				String sql = "{call SP_VALIDA_CONTADOR (?, ?)}";
		        stmt = conn.prepareCall(sql);			
				
		        stmt.setInt(1, cod_persona);
		        stmt.setString(2, cod_cont);
				rs = stmt.executeQuery();

				while (rs.next()) {
					
					cont.setCod_persona(rs.getInt("cod_persona"));					
				
				}

			} catch (SQLException ex) {
				ex.printStackTrace(System.out);
			} finally {
				conx.close(rs);
				conx.close(stmt);
				conx.close(conn);
			}
			return cont;
		}

}
