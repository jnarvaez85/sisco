package planillas;

public class Colaboradores {
	
	private int cod_colabora;
	private int cod_persona;
	private int cod_param;	
	private int estado_colabora;
	
	
	public Colaboradores() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Colaboradores(int cod_colabora, int cod_persona, int cod_param, int estado_colabora) {
		super();
		this.cod_colabora = cod_colabora;
		this.cod_persona = cod_persona;
		this.cod_param = cod_param;
		this.estado_colabora = estado_colabora;
	}


	public Colaboradores(int cod_colabora) {
		super();
		this.cod_colabora = cod_colabora;
	}


	public Colaboradores(int cod_persona, int cod_param, int estado_colabora) {
		super();
		this.cod_persona = cod_persona;
		this.cod_param = cod_param;
		this.estado_colabora = estado_colabora;
	}


	public int getCod_colabora() {
		return cod_colabora;
	}


	public void setCod_colabora(int cod_colabora) {
		this.cod_colabora = cod_colabora;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}


	public int getCod_param() {
		return cod_param;
	}


	public void setCod_param(int cod_param) {
		this.cod_param = cod_param;
	}


	public int getEstado_colabora() {
		return estado_colabora;
	}


	public void setEstado_colabora(int estado_colabora) {
		this.estado_colabora = estado_colabora;
	}
	
	
	

}
	