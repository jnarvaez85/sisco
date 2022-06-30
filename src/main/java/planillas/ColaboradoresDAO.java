package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;
import seguridad.Personas;
import seguridad.Usuarios;

public class ColaboradoresDAO {
	
	private final static int status_colabora=1;
	private static final String SELECT_COLABORA = "SELECT * FROM view_colaboradores WHERE cod_estado="+status_colabora;
	private static final String VER_COLABORADORES = "SELECT * FROM view_colaboradores";
	
	private static final String EXISTE_COLABORA = "SELECT COUNT(identificacion) identificacion FROM view_colaboradores WHERE identificacion= ?";
	
	// LISTAR NOMBRE DE COLABORADORES
			public static  LinkedList<VTcolaboradores> listarColaboradores() {
		    	LinkedList<VTcolaboradores> list_colabora= new LinkedList<VTcolaboradores> ();
		    	
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;	
		     
				try {
					con = conx.conectar();
					ps = con.prepareStatement(SELECT_COLABORA);	
					rs = ps.executeQuery();
					
		            while (rs.next()) {
		            	
		            	VTcolaboradores list_colab = new VTcolaboradores();
		            	
		            	list_colab.setCod_colabora(rs.getInt("cod_colabora"));
		            	list_colab.setCod_persona(rs.getInt("cod_persona"));
		            	list_colab.setTipo_identificacion(rs.getString("tipo_identificacion"));
		            	list_colab.setIdentificacion(rs.getString("identificacion"));
		            	list_colab.setNombre_colaborador(rs.getString("nombre_colaborador"));
		            	list_colab.setDir_colaborador(rs.getString("dir_colaborador"));
		            	list_colab.setTel_colaborador(rs.getString("tel_colaborador"));
		            	list_colab.setCod_estado(rs.getInt("cod_estado"));
		            	list_colab.setEstado(rs.getString("estado"));		            	
		            	
		            	list_colabora.add(list_colab);
		            }
		        } catch (SQLException e) {
					System.out.println("Error al listar colaboradores " + e);
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
				
				return list_colabora;
			}
			
			// MOSTRAR COLABORADORES
			public static  LinkedList<VTcolaboradores> mostrarColaboradores() {
		    	LinkedList<VTcolaboradores> mostrar_colabora= new LinkedList<VTcolaboradores> ();
		    	
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;	
		     
				try {
					con = conx.conectar();
					ps = con.prepareStatement(VER_COLABORADORES);	
					rs = ps.executeQuery();
					
		            while (rs.next()) {
		            	
		            	VTcolaboradores ver_colab = new VTcolaboradores();
		            	
		            	ver_colab.setCod_colabora(rs.getInt("cod_colabora"));
		            	ver_colab.setCod_persona(rs.getInt("cod_persona"));
		            	ver_colab.setTipo_identificacion(rs.getString("tipo_identificacion"));
		            	ver_colab.setIdentificacion(rs.getString("identificacion"));
		            	ver_colab.setNombre_colaborador(rs.getString("nombre_colaborador"));
		            	ver_colab.setDir_colaborador(rs.getString("dir_colaborador"));
		            	ver_colab.setTel_colaborador(rs.getString("tel_colaborador"));
		            	ver_colab.setCod_estado(rs.getInt("cod_estado"));
		            	ver_colab.setEstado(rs.getString("estado"));
		            	mostrar_colabora.add(ver_colab);
		            }
		        } catch (SQLException e) {
					System.out.println("Error al mostrar nombre de colaboradores " + e);
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
				
				return mostrar_colabora;
			}
			
					
			// AGREGAR COLABORADOR	
			public void insertarColaborador(String nom_persona, int tipo_doc, String doc_persona, String dir_persona, String tel_persona, int cursor) throws SQLException {
				
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				CallableStatement stmt = null;
				
				try {
					con = conx.conectar();
					
					 String sql = "{call SP_INSERT_COLABORADOR (?,?,?,?,?,?)}";
			         stmt = con.prepareCall(sql);
				
			         stmt.setString(1, nom_persona);
			         stmt.setInt(2, tipo_doc);
			         stmt.setString(3, doc_persona);
			         stmt.setString(4, dir_persona);
			         stmt.setString(5, tel_persona);
			         stmt.setInt(6, cursor);
			   			      		
			         stmt.executeUpdate();
					
		        } catch (SQLException e) {
						System.out.println("Error al insertar colaborador " + e);
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
			
			
			// BLOQUEAR COLABORADOR
						public static int bloquearColaborador(Colaboradores colabora) throws SQLException {

							int rows = 0;
							
						 	MysqlConexion conx = new MysqlConexion();
					    	Connection con = null;
					    	CallableStatement stmt = null;
					    	
							try {
								
								
								con = conx.conectar();					
								String sql = "{call SP_BLOQUEAR_COLABORADOR (?,?)}";
						        stmt = con.prepareCall(sql);	
											
						        stmt.setInt(1, colabora.getCod_colabora());						   
						        stmt.setInt(2, colabora.getEstado_colabora());
						       			

						        rows = stmt.executeUpdate();
								
							   } catch (SQLException e) {
									System.out.println("Error al bloquear colaborador " + e);
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
						
						
						// DESBLOQUEAR COLABORADOR
						public static int desbloquearColaborador(Colaboradores colabora) throws SQLException {

							int rows = 0;
							
						 	MysqlConexion conx = new MysqlConexion();
					    	Connection con = null;
					    	CallableStatement stmt = null;
					    	
							try {
								
								
								con = conx.conectar();					
								String sql = "{call SP_DESBLOQUEAR_COLABORADOR (?,?)}";
						        stmt = con.prepareCall(sql);	
											
						        stmt.setInt(1, colabora.getCod_colabora());						
						        stmt.setInt(2, colabora.getEstado_colabora());
						       			

						        rows = stmt.executeUpdate();
								
							   } catch (SQLException e) {
									System.out.println("Error al desbloquear colaborador " + e);
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
						
						
						// CONSULTAR COLABORADOR POR IDENTIFICACION			
						public int validarColaborador(String doc_persona) {
							
						 	MysqlConexion conx = new MysqlConexion();
					    	Connection con = null;
					    	CallableStatement stmt = null;
							ResultSet rs = null;
							
							
							try {
								
								con = conx.conectar();			
								
								 String sql = "{call SP_VALIDA_COLABORADOR (?)}";
						         stmt = con.prepareCall(sql);			

						         stmt.setString(1, doc_persona);					
								 rs=	stmt.executeQuery();
								
								if(rs.next()) {
									return rs.getInt(1);
								}
								MysqlConexion.close(rs);
								MysqlConexion.close(stmt);
								MysqlConexion.close(con);
								return 1;
								
							   } catch (SQLException e) {
									System.out.println("Error al validar colaborador " + e);
								}
					        
							finally {
								try {
									
									MysqlConexion.close(rs);
									MysqlConexion.close(stmt);
									MysqlConexion.close(con);
								} catch (SQLException e) {
									System.out.println("Error al cerrar" + e);
								}
							}
							return 1;
						}
						
						
						
							
						

}
