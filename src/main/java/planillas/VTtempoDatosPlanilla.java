package planillas;

import java.util.Date;

public class VTtempoDatosPlanilla {
	
	private int cod_temp_planilla; 
	private int cod_persona; 
	private String nom_contador; 
	private Date fecha_genera; 
	private Date fecha_planilla; 
	private int cod_servicio;
	private int cont_colabora; 
	private String nom_servicio; 
	private String hora_servicio; 
	private int cod_colabora1; 
	private String nom_colabora1; 
	private int cod_colabora2; 
	private String nom_colabora2; 
	private int cod_colabora3; 
	private String nom_colabora3;
	private int compartida; 
	
	
	public VTtempoDatosPlanilla() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VTtempoDatosPlanilla(int cod_temp_planilla, int cod_persona, String nom_contador, Date fecha_genera,
			Date fecha_planilla, int cod_servicio, int cont_colabora, String nom_servicio, String hora_servicio,
			int cod_colabora1, String nom_colabora1, int cod_colabora2, String nom_colabora2, int cod_colabora3,
			String nom_colabora3, int compartida) {
		super();
		this.cod_temp_planilla = cod_temp_planilla;
		this.cod_persona = cod_persona;
		this.nom_contador = nom_contador;
		this.fecha_genera = fecha_genera;
		this.fecha_planilla = fecha_planilla;
		this.cod_servicio = cod_servicio;
		this.cont_colabora = cont_colabora;
		this.nom_servicio = nom_servicio;
		this.hora_servicio = hora_servicio;
		this.cod_colabora1 = cod_colabora1;
		this.nom_colabora1 = nom_colabora1;
		this.cod_colabora2 = cod_colabora2;
		this.nom_colabora2 = nom_colabora2;
		this.cod_colabora3 = cod_colabora3;
		this.nom_colabora3 = nom_colabora3;
		this.compartida = compartida;
	}


	public VTtempoDatosPlanilla(int cod_temp_planilla) {
		super();
		this.cod_temp_planilla = cod_temp_planilla;
	}


	public VTtempoDatosPlanilla(int cod_persona, String nom_contador, Date fecha_genera, Date fecha_planilla,
			int cod_servicio, int cont_colabora, String nom_servicio, String hora_servicio, int cod_colabora1,
			String nom_colabora1, int cod_colabora2, String nom_colabora2, int cod_colabora3, String nom_colabora3, int compartida) {
		super();
		this.cod_persona = cod_persona;
		this.nom_contador = nom_contador;
		this.fecha_genera = fecha_genera;
		this.fecha_planilla = fecha_planilla;
		this.cod_servicio = cod_servicio;
		this.cont_colabora = cont_colabora;
		this.nom_servicio = nom_servicio;
		this.hora_servicio = hora_servicio;
		this.cod_colabora1 = cod_colabora1;
		this.nom_colabora1 = nom_colabora1;
		this.cod_colabora2 = cod_colabora2;
		this.nom_colabora2 = nom_colabora2;
		this.cod_colabora3 = cod_colabora3;
		this.nom_colabora3 = nom_colabora3;
		this.compartida = compartida;
	}


	public int getCod_temp_planilla() {
		return cod_temp_planilla;
	}


	public void setCod_temp_planilla(int cod_temp_planilla) {
		this.cod_temp_planilla = cod_temp_planilla;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}


	public String getNom_contador() {
		return nom_contador;
	}


	public void setNom_contador(String nom_contador) {
		this.nom_contador = nom_contador;
	}


	public Date getFecha_genera() {
		return fecha_genera;
	}


	public void setFecha_genera(Date fecha_genera) {
		this.fecha_genera = fecha_genera;
	}


	public Date getFecha_planilla() {
		return fecha_planilla;
	}


	public void setFecha_planilla(Date fecha_planilla) {
		this.fecha_planilla = fecha_planilla;
	}


	public int getCod_servicio() {
		return cod_servicio;
	}


	public void setCod_servicio(int cod_servicio) {
		this.cod_servicio = cod_servicio;
	}


	public int getCont_colabora() {
		return cont_colabora;
	}


	public void setCont_colabora(int cont_colabora) {
		this.cont_colabora = cont_colabora;
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


	public int getCod_colabora1() {
		return cod_colabora1;
	}


	public void setCod_colabora1(int cod_colabora1) {
		this.cod_colabora1 = cod_colabora1;
	}


	public String getNom_colabora1() {
		return nom_colabora1;
	}


	public void setNom_colabora1(String nom_colabora1) {
		this.nom_colabora1 = nom_colabora1;
	}


	public int getCod_colabora2() {
		return cod_colabora2;
	}


	public void setCod_colabora2(int cod_colabora2) {
		this.cod_colabora2 = cod_colabora2;
	}


	public String getNom_colabora2() {
		return nom_colabora2;
	}


	public void setNom_colabora2(String nom_colabora2) {
		this.nom_colabora2 = nom_colabora2;
	}


	public int getCod_colabora3() {
		return cod_colabora3;
	}


	public void setCod_colabora3(int cod_colabora3) {
		this.cod_colabora3 = cod_colabora3;
	}


	public String getNom_colabora3() {
		return nom_colabora3;
	}


	public void setNom_colabora3(String nom_colabora3) {
		this.nom_colabora3 = nom_colabora3;
	}
	
	
	public int getCompartida() {
		return compartida;
	}


	public void setCompartida(int compartida) {
		this.compartida = compartida;
	}



	
	
	

}
