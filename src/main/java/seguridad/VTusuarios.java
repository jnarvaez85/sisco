package seguridad;

import java.sql.Date;

public class VTusuarios {
	
	private int cod_persona;
	private int estado_cont;
	private String admin;
	private String nom_persona;	
	private int cod_id;
	private String tipo_identificacion;
	private String usuario;
	private String dir_persona;
	private String tel_persona;
	private Date fecha_inicio;
	private Date fecha_fin;
	private int cod_estado;
	private String estado;
	private int cod_rol;
	private String rol;
	private int estado_firma;

	
	
	public VTusuarios() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VTusuarios(int cod_persona, int estado_cont, String admin, String nom_persona, 
			int cod_id, String tipo_identificacion, String usuario, String dir_persona, String tel_persona,
			Date fecha_inicio, Date fecha_fin, int cod_estado, String estado, int cod_rol, String rol,
			int estado_firma) {
		super();
		this.cod_persona = cod_persona;
		this.estado_cont = estado_cont;
		this.admin = admin;
		this.nom_persona = nom_persona;		
		this.cod_id = cod_id;
		this.tipo_identificacion = tipo_identificacion;
		this.usuario = usuario;
		this.dir_persona = dir_persona;
		this.tel_persona = tel_persona;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cod_estado = cod_estado;
		this.estado = estado;
		this.cod_rol = cod_rol;
		this.rol = rol;
		this.estado_firma = estado_firma;
	}



	public VTusuarios(int cod_persona) {
		super();
		this.cod_persona = cod_persona;
	}



	public VTusuarios(int estado_cont, String admin, String nom_persona,  int cod_id,
			String tipo_identificacion, String usuario, String dir_persona, String tel_persona, Date fecha_inicio,
			Date fecha_fin, int cod_estado, String estado, int cod_rol, String rol, int estado_firma) {
		super();
		this.estado_cont = estado_cont;
		this.admin = admin;
		this.nom_persona = nom_persona;		
		this.cod_id = cod_id;
		this.tipo_identificacion = tipo_identificacion;
		this.usuario = usuario;
		this.dir_persona = dir_persona;
		this.tel_persona = tel_persona;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cod_estado = cod_estado;
		this.estado = estado;
		this.cod_rol = cod_rol;
		this.rol = rol;
		this.estado_firma = estado_firma;
	}



	public int getCod_persona() {
		return cod_persona;
	}



	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}



	public int getEstado_cont() {
		return estado_cont;
	}



	public void setEstado_cont(int estado_cont) {
		this.estado_cont = estado_cont;
	}



	public String getAdmin() {
		return admin;
	}



	public void setAdmin(String admin) {
		this.admin = admin;
	}



	public String getNom_persona() {
		return nom_persona;
	}



	public void setNom_persona(String nom_persona) {
		this.nom_persona = nom_persona;
	}



	public int getCod_id() {
		return cod_id;
	}



	public void setCod_id(int cod_id) {
		this.cod_id = cod_id;
	}



	public String getTipo_identificacion() {
		return tipo_identificacion;
	}



	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getDir_persona() {
		return dir_persona;
	}



	public void setDir_persona(String dir_persona) {
		this.dir_persona = dir_persona;
	}



	public String getTel_persona() {
		return tel_persona;
	}



	public void setTel_persona(String tel_persona) {
		this.tel_persona = tel_persona;
	}



	public Date getFecha_inicio() {
		return fecha_inicio;
	}



	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}



	public Date getFecha_fin() {
		return fecha_fin;
	}



	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}



	public int getCod_estado() {
		return cod_estado;
	}



	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getCod_rol() {
		return cod_rol;
	}



	public void setCod_rol(int cod_rol) {
		this.cod_rol = cod_rol;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	public int getEstado_firma() {
		return estado_firma;
	}



	public void setEstado_firma(int estado_firma) {
		this.estado_firma = estado_firma;
	}



	

	

}
