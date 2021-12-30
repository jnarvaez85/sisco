package seguridad;

public class Personas {
	
	private int cod_persona;
	private String nom_persona;	
	private int tipo_doc_persona;
	private String doc_persona;
	private String dir_persona;
	private String tel_persona;
	private int rol_persona;
	
	
	public Personas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Personas(int cod_persona, String nom_persona, int tipo_doc_persona, String doc_persona,
			String dir_persona, String tel_persona, int rol_persona) {
		super();
		this.cod_persona = cod_persona;
		this.nom_persona = nom_persona;		
		this.tipo_doc_persona = tipo_doc_persona;
		this.doc_persona = doc_persona;
		this.dir_persona = dir_persona;
		this.tel_persona = tel_persona;
		this.rol_persona = rol_persona;
	}


	public Personas(int cod_persona) {
		super();
		this.cod_persona = cod_persona;
	}


	public Personas(String nom_persona, int tipo_doc_persona, String doc_persona,
			String dir_persona, String tel_persona, int rol_persona) {
		super();
		this.nom_persona = nom_persona;		
		this.tipo_doc_persona = tipo_doc_persona;
		this.doc_persona = doc_persona;
		this.dir_persona = dir_persona;
		this.tel_persona = tel_persona;
		this.rol_persona = rol_persona;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}


	public String getNom_persona() {
		return nom_persona;
	}


	public void setNom_persona(String nom_persona) {
		this.nom_persona = nom_persona;
	}


	public int getTipo_doc_persona() {
		return tipo_doc_persona;
	}


	public void setTipo_doc_persona(int tipo_doc_persona) {
		this.tipo_doc_persona = tipo_doc_persona;
	}


	public String getDoc_persona() {
		return doc_persona;
	}


	public void setDoc_persona(String doc_persona) {
		this.doc_persona = doc_persona;
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


	public int getRol_persona() {
		return rol_persona;
	}


	public void setRol_persona(int rol_persona) {
		this.rol_persona = rol_persona;
	}
	
	
	
	

}
