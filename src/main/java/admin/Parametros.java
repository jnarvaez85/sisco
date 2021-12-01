package admin;

public class Parametros {
	
	private int cod_param;
	private int num_param;
	private String detalle_param;
	
	
	public Parametros() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Parametros(int cod_param, int num_param, String detalle_param) {
		super();
		this.cod_param = cod_param;
		this.num_param = num_param;
		this.detalle_param = detalle_param;
	}


	public Parametros(int cod_param) {
		super();
		this.cod_param = cod_param;
	}


	public Parametros(int num_param, String detalle_param) {
		super();
		this.num_param = num_param;
		this.detalle_param = detalle_param;
	}


	public int getCod_param() {
		return cod_param;
	}


	public void setCod_param(int cod_param) {
		this.cod_param = cod_param;
	}


	public int getNum_param() {
		return num_param;
	}


	public void setNum_param(int num_param) {
		this.num_param = num_param;
	}


	public String getDetalle_param() {
		return detalle_param;
	}


	public void setDetalle_param(String detalle_param) {
		this.detalle_param = detalle_param;
	}
	
	
	

}
