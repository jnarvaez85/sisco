package admin;

public class Systemas {

	private int cod_sys;
	private String nom_sys;
	private String ver_sys;
	private String desing_sys;
	
	
	public Systemas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Systemas(int cod_sys, String nom_sys, String ver_sys, String desing_sys) {
		super();
		this.cod_sys = cod_sys;
		this.nom_sys = nom_sys;
		this.ver_sys = ver_sys;
		this.desing_sys = desing_sys;
	}


	public Systemas(int cod_sys) {
		super();
		this.cod_sys = cod_sys;
	}


	public Systemas(String nom_sys, String ver_sys, String desing_sys) {
		super();
		this.nom_sys = nom_sys;
		this.ver_sys = ver_sys;
		this.desing_sys = desing_sys;
	}


	public int getCod_sys() {
		return cod_sys;
	}


	public void setCod_sys(int cod_sys) {
		this.cod_sys = cod_sys;
	}


	public String getNom_sys() {
		return nom_sys;
	}


	public void setNom_sys(String nom_sys) {
		this.nom_sys = nom_sys;
	}


	public String getVer_sys() {
		return ver_sys;
	}


	public void setVer_sys(String ver_sys) {
		this.ver_sys = ver_sys;
	}


	public String getDesing_sys() {
		return desing_sys;
	}


	public void setDesing_sys(String desing_sys) {
		this.desing_sys = desing_sys;
	}
	
	
	
	
	
	
}
