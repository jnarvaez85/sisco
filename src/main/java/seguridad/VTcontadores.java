package seguridad;

import java.util.Date;

public class VTcontadores {

	private int cod_persona;
	private String cod_cont;
	private String cargo_cont;
	private int cod_estado;
	private String estado;
	private String nom_contador;
	private int tipo_doc_persona;
	private String tipo_identificacion;
	private String doc_persona;
	private String dir_persona;
	private String tel_persona;
	private Date fecha_inicio_con;
	private Date fecha_fin_con;
	
	
	public VTcontadores() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VTcontadores(int cod_persona, String cod_cont, String cargo_cont, int cod_estado, String estado,
			String nom_contador, int tipo_doc_persona, String tipo_identificacion, String doc_persona,
			String dir_persona, String tel_persona, Date fecha_inicio_con, Date fecha_fin_con) {
		super();
		this.cod_persona = cod_persona;
		this.cod_cont = cod_cont;
		this.cargo_cont = cargo_cont;
		this.cod_estado = cod_estado;
		this.estado = estado;
		this.nom_contador = nom_contador;
		this.tipo_doc_persona = tipo_doc_persona;
		this.tipo_identificacion = tipo_identificacion;
		this.doc_persona = doc_persona;
		this.dir_persona = dir_persona;
		this.tel_persona = tel_persona;
		this.fecha_inicio_con = fecha_inicio_con;
		this.fecha_fin_con = fecha_fin_con;
	}


	public VTcontadores(int cod_persona) {
		super();
		this.cod_persona = cod_persona;
	}


	public VTcontadores(String cod_cont, String cargo_cont, int cod_estado, String estado, String nom_contador,
			int tipo_doc_persona, String tipo_identificacion, String doc_persona, String dir_persona,
			String tel_persona, Date fecha_inicio_con, Date fecha_fin_con) {
		super();
		this.cod_cont = cod_cont;
		this.cargo_cont = cargo_cont;
		this.cod_estado = cod_estado;
		this.estado = estado;
		this.nom_contador = nom_contador;
		this.tipo_doc_persona = tipo_doc_persona;
		this.tipo_identificacion = tipo_identificacion;
		this.doc_persona = doc_persona;
		this.dir_persona = dir_persona;
		this.tel_persona = tel_persona;
		this.fecha_inicio_con = fecha_inicio_con;
		this.fecha_fin_con = fecha_fin_con;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}


	public String getCod_cont() {
		return cod_cont;
	}


	public void setCod_cont(String cod_cont) {
		this.cod_cont = cod_cont;
	}


	public String getCargo_cont() {
		return cargo_cont;
	}


	public void setCargo_cont(String cargo_cont) {
		this.cargo_cont = cargo_cont;
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


	public String getNom_contador() {
		return nom_contador;
	}


	public void setNom_contador(String nom_contador) {
		this.nom_contador = nom_contador;
	}


	public int getTipo_doc_persona() {
		return tipo_doc_persona;
	}


	public void setTipo_doc_persona(int tipo_doc_persona) {
		this.tipo_doc_persona = tipo_doc_persona;
	}


	public String getTipo_identificacion() {
		return tipo_identificacion;
	}


	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
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


	public Date getFecha_inicio_con() {
		return fecha_inicio_con;
	}


	public void setFecha_inicio_con(Date fecha_inicio_con) {
		this.fecha_inicio_con = fecha_inicio_con;
	}


	public Date getFecha_fin_con() {
		return fecha_fin_con;
	}


	public void setFecha_fin_con(Date fecha_fin_con) {
		this.fecha_fin_con = fecha_fin_con;
	}


	
	
	
	
	
	
}
