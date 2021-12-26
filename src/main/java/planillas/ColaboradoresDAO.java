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
	private static final String SELECT_COLABORA = "SELECT * FROM planilla_colaboradores WHERE estado_colabora="+status_colabora;
	private static final String VER_COLABORADORES = "SELECT * FROM planilla_colaboradores";

	
	// LISTAR NOMBRE DE COLABORADORES
			public static  LinkedList<Colaboradores> listarColaboradores() {
		    	LinkedList<Colaboradores> list_colabora= new LinkedList<Colaboradores> ();
		    	
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;	
		     
				try {
					con = conx.conectar();
					ps = con.prepareStatement(SELECT_COLABORA);	
					rs = ps.executeQuery();
					
		            while (rs.next()) {
		            	
		            	Colaboradores list_colab = new Colaboradores();
		            	
		            	list_colab.setCod_colabora(rs.getInt("cod_colabora"));
		            	list_colab.setCod_param(rs.getInt("cod_param"));
		            	list_colab.setTipo_doc_colabora(rs.getInt("tipo_doc_colabora"));
		            	list_colab.setDoc_colabora(rs.getString("doc_colabora"));
		            	list_colab.setNom_colabora(rs.getString("nom_colabora"));
		            	list_colab.setEstado_colabora(rs.getInt("estado_colabora"));
		            	list_colabora.add(list_colab);
		            }
		        } catch (SQLException e) {
					System.out.println("Error al listar colaboradores" + e);
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
			public static  LinkedList<Colaboradores> mostrarColaboradores() {
		    	LinkedList<Colaboradores> mostrar_colabora= new LinkedList<Colaboradores> ();
		    	
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;	
		     
				try {
					con = conx.conectar();
					ps = con.prepareStatement(VER_COLABORADORES);	
					rs = ps.executeQuery();
					
		            while (rs.next()) {
		            	
		            	Colaboradores ver_colab = new Colaboradores();
		            	
		            	ver_colab.setCod_colabora(rs.getInt("cod_colabora"));
		            	ver_colab.setCod_param(rs.getInt("cod_param"));
		            	ver_colab.setTipo_doc_colabora(rs.getInt("tipo_doc_colabora"));
		            	ver_colab.setDoc_colabora(rs.getString("doc_colabora"));
		            	ver_colab.setNom_colabora(rs.getString("nom_colabora"));
		            	ver_colab.setEstado_colabora(rs.getInt("estado_colabora"));
		            	mostrar_colabora.add(ver_colab);
		            }
		        } catch (SQLException e) {
					System.out.println("Error al mostrar nombre de colaboradores" + e);
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
			public void insertarColaborador(Colaboradores colabora) throws SQLException {
				
		    	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
				CallableStatement stmt = null;
				
				try {
					con = conx.conectar();
					
					 String sql = "{call SP_INSERT_COLABORADOR (?,?,?)}";
			         stmt = con.prepareCall(sql);
				
			         stmt.setInt(1, colabora.getTipo_doc_colabora());
			         stmt.setString(2, colabora.getDoc_colabora());
			         stmt.setString(3, colabora.getNom_colabora());
			      		
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
								String sql = "{call SP_BLOQUEAR_COLABORADOR (?,?,?,?,?,?)}";
						        stmt = con.prepareCall(sql);	
											
						        stmt.setInt(1, colabora.getCod_colabora());
						        stmt.setInt(2, colabora.getCod_param() );
						        stmt.setInt(3, colabora.getTipo_doc_colabora());
						        stmt.setString(4,colabora.getDoc_colabora());
						        stmt.setString(5, colabora.getNom_colabora());
						        stmt.setInt(6, colabora.getEstado_colabora());
						       			

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
								String sql = "{call SP_DESBLOQUEAR_COLABORADOR (?,?,?,?,?,?)}";
						        stmt = con.prepareCall(sql);	
											
						        stmt.setInt(1, colabora.getCod_colabora());
						        stmt.setInt(2, colabora.getCod_param() );
						        stmt.setInt(3, colabora.getTipo_doc_colabora());
						        stmt.setString(4,colabora.getDoc_colabora());
						        stmt.setString(5, colabora.getNom_colabora());
						        stmt.setInt(6, colabora.getEstado_colabora());
						       			

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
						
						
						// CONSULTAR COLABORADOR			
						public int validarColaborador(String doc_colabora) {
							
						 	MysqlConexion conx = new MysqlConexion();
					    	Connection con = null;
					    	CallableStatement stmt = null;
							ResultSet rs = null;
							
							
							try {
								
								con = conx.conectar();			
								
								 String sql = "{call SP_VALIDA_COLABORADOR (?)}";
						         stmt = con.prepareCall(sql);			

						         stmt.setString(1, doc_colabora);					
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
