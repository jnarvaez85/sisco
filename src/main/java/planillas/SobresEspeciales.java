package planillas;

public class SobresEspeciales {
	
	private int cod_especial;
	private String nom_sobre_especial;
	
	
	public SobresEspeciales() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SobresEspeciales(int cod_especial, String nom_sobre_especial) {
		super();
		this.cod_especial = cod_especial;
		this.nom_sobre_especial = nom_sobre_especial;
	}


	public SobresEspeciales(int cod_especial) {
		super();
		this.cod_especial = cod_especial;
	}


	public SobresEspeciales(String nom_sobre_especial) {
		super();
		this.nom_sobre_especial = nom_sobre_especial;
	}


	public int getCod_especial() {
		return cod_especial;
	}


	public void setCod_especial(int cod_especial) {
		this.cod_especial = cod_especial;
	}


	public String getNom_sobre_especial() {
		return nom_sobre_especial;
	}


	public void setNom_sobre_especial(String nom_sobre_especial) {
		this.nom_sobre_especial = nom_sobre_especial;
	}
	
	
	
	

}
