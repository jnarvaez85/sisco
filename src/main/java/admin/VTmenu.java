package admin;

public class VTmenu {
	
	private int cod_rol;
	private String rol;
	private String opcion;
	private int cod_modulo;
	private String modulo;
	private int cod_tipo_menu;
	private String tipo_menu;
	private String icon_menu;
	private String link_menu;
	private int permiso;
	private String estado_permiso;
	private int estado_menu;
	private String menu;
	private int cod_enlace;
	private String tipo_enlace;
	
	
	public VTmenu() {
		super();
		// TODO Auto-generated constructor stub
	}




	public VTmenu(int cod_rol, String rol, String opcion, int cod_modulo, String modulo, int cod_tipo_menu,
			String tipo_menu, String icon_menu, String link_menu, int permiso, String estado_permiso, int estado_menu,
			String menu, int cod_enlace, String tipo_enlace) {
		super();
		this.cod_rol = cod_rol;
		this.rol = rol;
		this.opcion = opcion;
		this.cod_modulo = cod_modulo;
		this.modulo = modulo;
		this.cod_tipo_menu = cod_tipo_menu;
		this.tipo_menu = tipo_menu;
		this.icon_menu = icon_menu;
		this.link_menu = link_menu;
		this.permiso = permiso;
		this.estado_permiso = estado_permiso;
		this.estado_menu = estado_menu;
		this.menu = menu;
		this.cod_enlace = cod_enlace;
		this.tipo_enlace = tipo_enlace;
	}




	public VTmenu(int cod_rol) {
		super();
		this.cod_rol = cod_rol;
	}





	public VTmenu(String rol, String opcion, int cod_modulo, String modulo, int cod_tipo_menu, String tipo_menu,
			String icon_menu, String link_menu, int permiso, String estado_permiso, int estado_menu, String menu,
			int cod_enlace, String tipo_enlace) {
		super();
		this.rol = rol;
		this.opcion = opcion;
		this.cod_modulo = cod_modulo;
		this.modulo = modulo;
		this.cod_tipo_menu = cod_tipo_menu;
		this.tipo_menu = tipo_menu;
		this.icon_menu = icon_menu;
		this.link_menu = link_menu;
		this.permiso = permiso;
		this.estado_permiso = estado_permiso;
		this.estado_menu = estado_menu;
		this.menu = menu;
		this.cod_enlace = cod_enlace;
		this.tipo_enlace = tipo_enlace;
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




	public String getOpcion() {
		return opcion;
	}




	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}




	public int getCod_modulo() {
		return cod_modulo;
	}




	public void setCod_modulo(int cod_modulo) {
		this.cod_modulo = cod_modulo;
	}




	public String getModulo() {
		return modulo;
	}




	public void setModulo(String modulo) {
		this.modulo = modulo;
	}




	public int getCod_tipo_menu() {
		return cod_tipo_menu;
	}




	public void setCod_tipo_menu(int cod_tipo_menu) {
		this.cod_tipo_menu = cod_tipo_menu;
	}




	public String getTipo_menu() {
		return tipo_menu;
	}




	public void setTipo_menu(String tipo_menu) {
		this.tipo_menu = tipo_menu;
	}




	public String getIcon_menu() {
		return icon_menu;
	}




	public void setIcon_menu(String icon_menu) {
		this.icon_menu = icon_menu;
	}




	public String getLink_menu() {
		return link_menu;
	}




	public void setLink_menu(String link_menu) {
		this.link_menu = link_menu;
	}




	public int getPermiso() {
		return permiso;
	}




	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}




	public String getEstado_permiso() {
		return estado_permiso;
	}




	public void setEstado_permiso(String estado_permiso) {
		this.estado_permiso = estado_permiso;
	}




	public int getEstado_menu() {
		return estado_menu;
	}




	public void setEstado_menu(int estado_menu) {
		this.estado_menu = estado_menu;
	}




	public String getMenu() {
		return menu;
	}




	public void setMenu(String menu) {
		this.menu = menu;
	}




	public int getCod_enlace() {
		return cod_enlace;
	}




	public void setCod_enlace(int cod_enlace) {
		this.cod_enlace = cod_enlace;
	}




	public String getTipo_enlace() {
		return tipo_enlace;
	}




	public void setTipo_enlace(String tipo_enlace) {
		this.tipo_enlace = tipo_enlace;
	}




	
	
	

}
