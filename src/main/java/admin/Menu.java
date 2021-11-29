package admin;

public class Menu {
	
	private int cod_menu;
	private int cod_menu_param;
	private String nom_menu;
	private int estado_menu;
	private String icon_menu;
	private String link_menu;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int cod_menu, int cod_menu_param, String nom_menu, int estado_menu, String icon_menu, String link_menu) {
		super();
		this.cod_menu = cod_menu;
		this.cod_menu_param = cod_menu_param;
		this.nom_menu = nom_menu;
		this.estado_menu = estado_menu;
		this.icon_menu = icon_menu;
		this.link_menu = link_menu;
	}

	public Menu(int cod_menu) {
		super();
		this.cod_menu = cod_menu;
	}

	public Menu(int cod_menu_param, String nom_menu, int estado_menu, String icon_menu, String link_menu) {
		super();
		this.cod_menu_param = cod_menu_param;
		this.nom_menu = nom_menu;
		this.estado_menu = estado_menu;
		this.icon_menu = icon_menu;
		this.link_menu = link_menu;
	}

	public int getCod_menu() {
		return cod_menu;
	}

	public void setCod_menu(int cod_menu) {
		this.cod_menu = cod_menu;
	}

	public int getCod_menu_param() {
		return cod_menu_param;
	}

	public void setCod_menu_param(int cod_menu_param) {
		this.cod_menu_param = cod_menu_param;
	}

	public String getNom_menu() {
		return nom_menu;
	}

	public void setNom_menu(String nom_menu) {
		this.nom_menu = nom_menu;
	}

	public int getEstado_menu() {
		return estado_menu;
	}

	public void setEstado_menu(int estado_menu) {
		this.estado_menu = estado_menu;
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
	
	
	

}
