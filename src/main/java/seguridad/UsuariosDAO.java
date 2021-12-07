package seguridad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import admin.Entidad;
import db.MysqlConexion;

public class UsuariosDAO {
	
	MysqlConexion conx = new MysqlConexion();

	private static final String SELECT_USER = "SELECT * FROM view_usuarios";
	private static final String SELECT_ROL="	SELECT \r\n"
			+ "	distinct\r\n"
			+ "	menu.cod_rol,\r\n"
			+ "	menu.rol\r\n"
			+ "	FROM segur_usuario usr \r\n"
			+ "	INNER JOIN view_menu menu\r\n"
			+ "	ON usr.cod_rol=menu.cod_rol WHERE usr.segur_user = ?";


	
	// VALIDAR LOGIN
	@SuppressWarnings("static-access")
	public VTusuarios validarLogin(String segur_user, String segur_password) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		CallableStatement stmt = null;

		VTusuarios user = new VTusuarios();

		try {

			conn = conx.conectar();
			
			String sql = "{call SP_VALIDA_LOGIN (?, ?)}";
	        stmt = conn.prepareCall(sql);			
			
	        stmt.setString(1, segur_user);
	        stmt.setString(2, segur_password);
			rs = stmt.executeQuery();

			while (rs.next()) {
				user.setNom_persona(rs.getString("nom_persona"));
				user.setApell_persona(rs.getString("apell_persona"));
				user.setTipo_identificacion(rs.getString("tipo_identificacion"));
				user.setUsuario(rs.getString("usuario"));
				user.setDir_persona(rs.getString("dir_persona"));
				user.setTel_persona(rs.getString("tel_persona"));
				user.setFecha_inicio(rs.getDate("fecha_inicio"));
				user.setFecha_fin(rs.getDate("fecha_fin"));
				user.setEstado(rs.getString("estado"));
				user.setRol(rs.getString("rol"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			conx.close(rs);
			conx.close(stmt);
			conx.close(conn);
		}
		return user;
	}
	
	
	
	
	// LISTAR DATOS DEL USUARIO
		public static  LinkedList<VTusuarios> listarUsuarios() {
	    	LinkedList<VTusuarios> list_usuarios = new LinkedList<VTusuarios> ();
	    	
	    	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;	
	     
			try {
				con = conx.conectar();
				ps = con.prepareStatement(SELECT_USER);	
				rs = ps.executeQuery();
				
	            while (rs.next()) {
	            	
	            	VTusuarios list_user = new VTusuarios();
	            	
	            	list_user.setCod_persona(rs.getInt("cod_persona"));
	            	list_user.setNom_persona(rs.getString("nom_persona"));
	            	list_user.setApell_persona(rs.getString("apell_persona"));
	            	list_user.setTipo_identificacion(rs.getString("tipo_identificacion"));
	            	list_user.setUsuario(rs.getString("usuario"));
	            	list_user.setDir_persona(rs.getString("dir_persona"));
	            	list_user.setTel_persona(rs.getString("tel_persona"));
	            	list_user.setFecha_inicio(rs.getDate("fecha_inicio"));
					list_user.setFecha_fin(rs.getDate("fecha_fin"));
					list_user.setCod_estado(rs.getInt("cod_estado"));
					list_user.setEstado(rs.getString("estado"));
					list_user.setRol(rs.getString("rol"));
					list_user.setEstado_firma(rs.getInt("estado_firma"));		
					list_usuarios.add(list_user);
	            }
	        } catch (SQLException e) {
				System.out.println("Error al mostrar a los usuarios " + e);
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
			
			return list_usuarios;
		}
		
		
		
		// VALIDAR EXISTENCIA DE UN USUARIO
		public int validarUsuario(String usuario) {
			
		 	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
	    	CallableStatement stmt = null;
			ResultSet rs = null;
			
			try {
				
				con = conx.conectar();			
				
				 String sql = "{call SP_VALIDA_USUARIO (?)}";
		         stmt = con.prepareCall(sql);			

		         stmt.setString(1, usuario);					
				 rs=	stmt.executeQuery();
				
				if(rs.next()) {
					return rs.getInt(1);
				}
				MysqlConexion.close(rs);
				MysqlConexion.close(stmt);
				MysqlConexion.close(con);
				return 1;
				
			   } catch (SQLException e) {
					System.out.println("Error al mostrar a los usuarios " + e);
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
		
		
		// INSERTAR USUARIO		
		public void insertarUsuario(Personas user) throws SQLException {
			
	    	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
			CallableStatement stmt = null;
			
			try {
				con = conx.conectar();
				
				 String sql = "{call SP_INSERT_PERSONA (?,?,?,?,?,?,?)}";
		         stmt = con.prepareCall(sql);
			
		         stmt.setString(1, user.getNom_persona());
		         stmt.setString(2, user.getApell_persona());
		         stmt.setInt(3, user.getTipo_doc_persona());
		         stmt.setString(4, user.getDoc_persona());
		         stmt.setString(5, user.getDir_persona());
		         stmt.setString(6, user.getTel_persona());
		         stmt.setInt(7, user.getRol_persona());			
		         stmt.executeUpdate();
				
	        } catch (SQLException e) {
					System.out.println("Error al insertar usuario " + e);
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
		
		
		
		// VALIDAR EL ROL		
			public Usuarios validarRol(String segur_user) {
			
		 	MysqlConexion conx = new MysqlConexion();
	    	Connection con = null;
	    	PreparedStatement ps = null;
			ResultSet rs = null;
			
			Usuarios rol = new Usuarios();
			
			try {
				
				con = conx.conectar();					
				ps = con.prepareStatement(SELECT_ROL);		

		         ps.setString(1, segur_user);					
				 rs=	ps.executeQuery();
				
				if(rs.next()) {
					 rol.setCod_rol(rs.getInt("cod_rol"));				}
				
				
			   } catch (SQLException e) {
					System.out.println("Error al mostrar a los usuarios " + e);
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
			return rol;
		}
			
			
			// ELIMINAR USUARIO	
			public static int eliminarUsuario(int cod_persona) throws SQLException {

				int rows = 0;
				
			 	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
		    	CallableStatement stmt = null;
		    	

				try {
					con = conx.conectar();					

					String sql = "{call SP_ELIMINA_USUARIO (?)}";
			        stmt = con.prepareCall(sql);						
			
			        stmt.setInt(1, cod_persona);
										
					rows = stmt.executeUpdate();
					
					
				   } catch (SQLException e) {
						System.out.println("Error al eliminar usuarios " + e);
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
			
			// BLOQUEAR USUARIO
			public static int bloquearUsuario(Usuarios user) throws SQLException {

				int rows = 0;
				
			 	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
		    	CallableStatement stmt = null;
		    	
				try {
					
					
					con = conx.conectar();					
					String sql = "{call SP_BLOQUEAR_USUARIO (?,?,?,?,?,?,?)}";
			        stmt = con.prepareCall(sql);	
								
			        stmt.setInt(1, user.getCod_persona());
			        stmt.setInt(2, user.getCod_rol() );
			        stmt.setInt(3, user.getEstado_user());
			        stmt.setDate(4, (Date) user.getFecha_fin_user());
			        stmt.setDate(5, (Date) user.getFecha_inicio_user());
			        stmt.setString(6, user.getSegur_password());
			        stmt.setString(7, user.getSegur_user());			

			        rows = stmt.executeUpdate();
					
				   } catch (SQLException e) {
						System.out.println("Error al bloquear/desbloquear usuario " + e);
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
			
			
			// RESETEAR CONTRASEÑA
			public static int resetearPassword(Usuarios user) throws SQLException {

				int rows = 0;
				
			 	MysqlConexion conx = new MysqlConexion();
		    	Connection con = null;
		    	CallableStatement stmt = null;
		    	
				try {
					
					
					con = conx.conectar();					
					String sql = "{call SP_RESETEAR_PASSWORD (?,?,?,?,?,?,?)}";
			        stmt = con.prepareCall(sql);	
								
			        stmt.setInt(1, user.getCod_persona());
			        stmt.setInt(2, user.getCod_rol() );
			        stmt.setInt(3, user.getEstado_user());
			        stmt.setDate(4, (Date) user.getFecha_fin_user());
			        stmt.setDate(5, (Date) user.getFecha_inicio_user());
			        stmt.setString(6, user.getSegur_password());
			        stmt.setString(7, user.getSegur_user());			

			        rows = stmt.executeUpdate();
					
				   } catch (SQLException e) {
						System.out.println("Error al resetear contraseña " + e);
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
		
			
			// MODIFICAR USUARIO
						public static int modificarUsuario(Personas persona) throws SQLException {

							int rows = 0;
							
						 	MysqlConexion conx = new MysqlConexion();
					    	Connection con = null;
					    	CallableStatement stmt = null;
					    	
							try {								
								
								con = conx.conectar();					
								String sql = "{call SP_MODIFICA_USUARIO (?,?,?,?,?,?,?,?)}";
						        stmt = con.prepareCall(sql);	
											
						        stmt.setInt(1, persona.getCod_persona());						        
						        stmt.setInt(2, persona.getTipo_doc_persona());
						        stmt.setString(3, persona.getDoc_persona());
						        stmt.setString(4, persona.getNom_persona());
						        stmt.setString(5, persona.getApell_persona());
						        stmt.setString(6, persona.getDir_persona());
						        stmt.setString(7, persona.getTel_persona());
						        stmt.setInt(8, persona.getRol_persona() );
								

						        rows = stmt.executeUpdate();
								
							   } catch (SQLException e) {
									System.out.println("Error al modificar usuario " + e);
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
