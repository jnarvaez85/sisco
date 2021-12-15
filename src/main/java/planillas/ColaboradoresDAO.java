package planillas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import db.MysqlConexion;
import seguridad.Personas;

public class ColaboradoresDAO {
	
	private static final String SELECT_COLABORA = "SELECT * FROM planilla_colaboradores";
	
	
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
				
				return list_colabora;
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

}
