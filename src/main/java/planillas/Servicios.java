package planillas;

public class Servicios {
	
	private int cod_servicio;
	private String nom_servicio;
	private String hora_servicio;
	
	
	public Servicios() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Servicios(int cod_servicio, String nom_servicio, String hora_servicio) {
		super();
		this.cod_servicio = cod_servicio;
		this.nom_servicio = nom_servicio;
		this.hora_servicio = hora_servicio;
	}


	public Servicios(int cod_servicio) {
		super();
		this.cod_servicio = cod_servicio;
	}


	public Servicios(String nom_servicio, String hora_servicio) {
		super();
		this.nom_servicio = nom_servicio;
		this.hora_servicio = hora_servicio;
	}


	public int getCod_servicio() {
		return cod_servicio;
	}


	public void setCod_servicio(int cod_servicio) {
		this.cod_servicio = cod_servicio;
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
	
	
	
	

}
