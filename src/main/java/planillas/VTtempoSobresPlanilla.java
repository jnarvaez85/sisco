package planillas;

import java.sql.Date;

public class VTtempoSobresPlanilla {
	
	private int cod_sobre;
	private Date fecha_planilla; 
	private String nom_servicio; 
	private String hora_servicio; 
	private int cod_persona; 
	private String nom_persona; 
	private String doc_persona; 
	private int diezmos; 
	private int ofrendas; 
	private int necesitados; 
	private int mercados; 
	private int construccion; 
	private int misiones; 
	private int otros; 
	private int especial; 
	private String nom_contador; 
	private String nom_colabora1; 
	private String nom_colabora2; 
	private String nom_colabora3;
	
	
	public VTtempoSobresPlanilla() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VTtempoSobresPlanilla(int cod_sobre, Date fecha_planilla, String nom_servicio, String hora_servicio,
			int cod_persona, String nom_persona, String doc_persona, int diezmos, int ofrendas, int necesitados,
			int mercados, int construccion, int misiones, int otros, int especial, String nom_contador,
			String nom_colabora1, String nom_colabora2, String nom_colabora3) {
		super();
		this.cod_sobre = cod_sobre;
		this.fecha_planilla = fecha_planilla;
		this.nom_servicio = nom_servicio;
		this.hora_servicio = hora_servicio;
		this.cod_persona = cod_persona;
		this.nom_persona = nom_persona;
		this.doc_persona = doc_persona;
		this.diezmos = diezmos;
		this.ofrendas = ofrendas;
		this.necesitados = necesitados;
		this.mercados = mercados;
		this.construccion = construccion;
		this.misiones = misiones;
		this.otros = otros;
		this.especial = especial;
		this.nom_contador = nom_contador;
		this.nom_colabora1 = nom_colabora1;
		this.nom_colabora2 = nom_colabora2;
		this.nom_colabora3 = nom_colabora3;
	}


	public VTtempoSobresPlanilla(int cod_sobre) {
		super();
		this.cod_sobre = cod_sobre;
	}


	public VTtempoSobresPlanilla(Date fecha_planilla, String nom_servicio, String hora_servicio, int cod_persona,
			String nom_persona, String doc_persona, int diezmos, int ofrendas, int necesitados, int mercados,
			int construccion, int misiones, int otros, int especial, String nom_contador, String nom_colabora1,
			String nom_colabora2, String nom_colabora3) {
		super();
		this.fecha_planilla = fecha_planilla;
		this.nom_servicio = nom_servicio;
		this.hora_servicio = hora_servicio;
		this.cod_persona = cod_persona;
		this.nom_persona = nom_persona;
		this.doc_persona = doc_persona;
		this.diezmos = diezmos;
		this.ofrendas = ofrendas;
		this.necesitados = necesitados;
		this.mercados = mercados;
		this.construccion = construccion;
		this.misiones = misiones;
		this.otros = otros;
		this.especial = especial;
		this.nom_contador = nom_contador;
		this.nom_colabora1 = nom_colabora1;
		this.nom_colabora2 = nom_colabora2;
		this.nom_colabora3 = nom_colabora3;
	}


	public int getCod_sobre() {
		return cod_sobre;
	}


	public void setCod_sobre(int cod_sobre) {
		this.cod_sobre = cod_sobre;
	}


	public Date getFecha_planilla() {
		return fecha_planilla;
	}


	public void setFecha_planilla(Date fecha_planilla) {
		this.fecha_planilla = fecha_planilla;
	}


	public String getNom_servicio() {
		return nom_servicio;
	}


	public void setNom_servicio(String nom_servicio) {
		this.nom_servicio = nom_servicio;
	}


	public String getHora_servicio() {
		return hora_servicio;
	}


	public void setHora_servicio(String hora_servicio) {
		this.hora_servicio = hora_servicio;
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


	public String getDoc_persona() {
		return doc_persona;
	}


	public void setDoc_persona(String doc_persona) {
		this.doc_persona = doc_persona;
	}


	public int getDiezmos() {
		return diezmos;
	}


	public void setDiezmos(int diezmos) {
		this.diezmos = diezmos;
	}


	public int getOfrendas() {
		return ofrendas;
	}


	public void setOfrendas(int ofrendas) {
		this.ofrendas = ofrendas;
	}


	public int getNecesitados() {
		return necesitados;
	}


	public void setNecesitados(int necesitados) {
		this.necesitados = necesitados;
	}


	public int getMercados() {
		return mercados;
	}


	public void setMercados(int mercados) {
		this.mercados = mercados;
	}


	public int getConstruccion() {
		return construccion;
	}


	public void setConstruccion(int construccion) {
		this.construccion = construccion;
	}


	public int getMisiones() {
		return misiones;
	}


	public void setMisiones(int misiones) {
		this.misiones = misiones;
	}


	public int getOtros() {
		return otros;
	}


	public void setOtros(int otros) {
		this.otros = otros;
	}


	public int getEspecial() {
		return especial;
	}


	public void setEspecial(int especial) {
		this.especial = especial;
	}


	public String getNom_contador() {
		return nom_contador;
	}


	public void setNom_contador(String nom_contador) {
		this.nom_contador = nom_contador;
	}


	public String getNom_colabora1() {
		return nom_colabora1;
	}


	public void setNom_colabora1(String nom_colabora1) {
		this.nom_colabora1 = nom_colabora1;
	}


	public String getNom_colabora2() {
		return nom_colabora2;
	}


	public void setNom_colabora2(String nom_colabora2) {
		this.nom_colabora2 = nom_colabora2;
	}


	public String getNom_colabora3() {
		return nom_colabora3;
	}


	public void setNom_colabora3(String nom_colabora3) {
		this.nom_colabora3 = nom_colabora3;
	}
	
	
	
	

}
