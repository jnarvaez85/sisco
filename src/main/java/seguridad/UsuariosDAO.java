package seguridad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MysqlConexion;

public class UsuariosDAO {
	
	MysqlConexion conx = new MysqlConexion();

	//private static final String SELECT_COUNT = "SELECT COUNT(SEGUR_USER) FROM segur_usuarios WHERE SEGUR_USER = ?";
	private static final String SELECT_LOGUIN = "SELECT \r\n"
			+ "per.*,\r\n"
			+ "usr.segur_user,\r\n"
			+ "usr.segur_password\r\n"
			+ "FROM segur_usuario usr\r\n"
			+ "INNER JOIN view_usuarios per ON usr.cod_persona=per.cod_persona\r\n"
			+ "WHERE segur_user =? AND segur_password = ?";


	// METODO PARA VALIDAR LOGIN
	@SuppressWarnings("static-access")
	public VTusuarios validarLogin(String segur_user, String segur_password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		VTusuarios user = new VTusuarios();

		try {

			conn = conx.conectar();
			ps = conn.prepareStatement(SELECT_LOGUIN);
			ps.setString(1, segur_user);
			ps.setString(2, segur_password);
			rs = ps.executeQuery();

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
			conx.close(ps);
			conx.close(conn);
		}
		return user;
	}

}
