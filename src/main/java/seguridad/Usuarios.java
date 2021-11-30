package seguridad;

import java.util.Date;

public class Usuarios {
	
	private int cod_persona;
	private String segur_user;
	private String segur_password;
	private Date fecha_inicio_user;
	private Date fecha_fin_user;
	private int estado_user;
	private int cod_rol;
	
	
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuarios(int cod_persona, String segur_user, String segur_password, Date fecha_inicio_user,
			Date fecha_fin_user, int estado_user, int cod_rol) {
		super();
		this.cod_persona = cod_persona;
		this.segur_user = segur_user;
		this.segur_password = segur_password;
		this.fecha_inicio_user = fecha_inicio_user;
		this.fecha_fin_user = fecha_fin_user;
		this.estado_user = estado_user;
		this.cod_rol = cod_rol;
	}


	public Usuarios(int cod_persona) {
		super();
		this.cod_persona = cod_persona;
	}


	public Usuarios(String segur_user, String segur_password, Date fecha_inicio_user, Date fecha_fin_user,
			int estado_user, int cod_rol) {
		super();
		this.segur_user = segur_user;
		this.segur_password = segur_password;
		this.fecha_inicio_user = fecha_inicio_user;
		this.fecha_fin_user = fecha_fin_user;
		this.estado_user = estado_user;
		this.cod_rol = cod_rol;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}


	public String getSegur_user() {
		return segur_user;
	}


	public void setSegur_user(String segur_user) {
		this.segur_user = segur_user;
	}


	public String getSegur_password() {
		return segur_password;
	}


	public void setSegur_password(String segur_password) {
		this.segur_password = segur_password;
	}


	public Date getFecha_inicio_user() {
		return fecha_inicio_user;
	}


	public void setFecha_inicio_user(Date fecha_inicio_user) {
		this.fecha_inicio_user = fecha_inicio_user;
	}


	public Date getFecha_fin_user() {
		return fecha_fin_user;
	}


	public void setFecha_fin_user(Date fecha_fin_user) {
		this.fecha_fin_user = fecha_fin_user;
	}


	public int getEstado_user() {
		return estado_user;
	}


	public void setEstado_user(int estado_user) {
		this.estado_user = estado_user;
	}


	public int getCod_rol() {
		return cod_rol;
	}


	public void setCod_rol(int cod_rol) {
		this.cod_rol = cod_rol;
	}
	
	
	
	

}
