package admin;

public class Entidad {
	private int cod_entidad;
	private String nom_entidad;
	private String nit_entidad;
	private String dir_entidad;
	private String tel_entidad;
	private String otro_entidad;
	
	
	public Entidad() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Entidad(int cod_entidad, String nom_entidad, String nit_entidad, String dir_entidad, String tel_entidad,
			String otro_entidad) {
		super();
		this.cod_entidad = cod_entidad;
		this.nom_entidad = nom_entidad;
		this.nit_entidad = nit_entidad;
		this.dir_entidad = dir_entidad;
		this.tel_entidad = tel_entidad;
		this.otro_entidad = otro_entidad;
	}


	public Entidad(int cod_entidad) {
		super();
		this.cod_entidad = cod_entidad;
	}


	public Entidad(String nom_entidad, String nit_entidad, String dir_entidad, String tel_entidad,
			String otro_entidad) {
		super();
		this.nom_entidad = nom_entidad;
		this.nit_entidad = nit_entidad;
		this.dir_entidad = dir_entidad;
		this.tel_entidad = tel_entidad;
		this.otro_entidad = otro_entidad;
	}


	public int getCod_entidad() {
		return cod_entidad;
	}


	public void setCod_entidad(int cod_entidad) {
		this.cod_entidad = cod_entidad;
	}


	public String getNom_entidad() {
		return nom_entidad;
	}


	public void setNom_entidad(String nom_entidad) {
		this.nom_entidad = nom_entidad;
	}


	public String getNit_entidad() {
		return nit_entidad;
	}


	public void setNit_entidad(String nit_entidad) {
		this.nit_entidad = nit_entidad;
	}


	public String getDir_entidad() {
		return dir_entidad;
	}


	public void setDir_entidad(String dir_entidad) {
		this.dir_entidad = dir_entidad;
	}


	public String getTel_entidad() {
		return tel_entidad;
	}


	public void setTel_entidad(String tel_entidad) {
		this.tel_entidad = tel_entidad;
	}


	public String getOtro_entidad() {
		return otro_entidad;
	}


	public void setOtro_entidad(String otro_entidad) {
		this.otro_entidad = otro_entidad;
	}
	
	
	
	
	

}
