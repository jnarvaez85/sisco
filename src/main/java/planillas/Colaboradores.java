package planillas;

public class Colaboradores {
	
	private int cod_colabora;
	private int cod_param;
	private int tipo_doc_colabora;
	private String doc_colabora;
	private String nom_colabora;
	private int estado_colabora;
	
	
	public Colaboradores() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Colaboradores(int cod_colabora, int cod_param, int tipo_doc_colabora, String doc_colabora,
			String nom_colabora, int estado_colabora) {
		super();
		this.cod_colabora = cod_colabora;
		this.cod_param = cod_param;
		this.tipo_doc_colabora = tipo_doc_colabora;
		this.doc_colabora = doc_colabora;
		this.nom_colabora = nom_colabora;
		this.estado_colabora = estado_colabora;
	}


	public Colaboradores(int cod_colabora) {
		super();
		this.cod_colabora = cod_colabora;
	}


	public Colaboradores(int cod_param, int tipo_doc_colabora, String doc_colabora, String nom_colabora,
			int estado_colabora) {
		super();
		this.cod_param = cod_param;
		this.tipo_doc_colabora = tipo_doc_colabora;
		this.doc_colabora = doc_colabora;
		this.nom_colabora = nom_colabora;
		this.estado_colabora = estado_colabora;
	}


	public int getCod_colabora() {
		return cod_colabora;
	}


	public void setCod_colabora(int cod_colabora) {
		this.cod_colabora = cod_colabora;
	}


	public int getCod_param() {
		return cod_param;
	}


	public void setCod_param(int cod_param) {
		this.cod_param = cod_param;
	}


	public int getTipo_doc_colabora() {
		return tipo_doc_colabora;
	}


	public void setTipo_doc_colabora(int tipo_doc_colabora) {
		this.tipo_doc_colabora = tipo_doc_colabora;
	}


	public String getDoc_colabora() {
		return doc_colabora;
	}


	public void setDoc_colabora(String doc_colabora) {
		this.doc_colabora = doc_colabora;
	}


	public String getNom_colabora() {
		return nom_colabora;
	}


	public void setNom_colabora(String nom_colabora) {
		this.nom_colabora = nom_colabora;
	}


	public int getEstado_colabora() {
		return estado_colabora;
	}


	public void setEstado_colabora(int estado_colabora) {
		this.estado_colabora = estado_colabora;
	}


	
	
	

}
