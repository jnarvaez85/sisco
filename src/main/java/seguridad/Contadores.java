package seguridad;

import java.util.Date;

public class Contadores {
	
	private int cod_persona;
	private int cod_cont;
	private String cargo_cont;
	private int estado_cont;
	private Date fecha_inicio_con;
	private Date fecha_fin_con;
	
	
	public Contadores() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Contadores(int cod_persona, int cod_cont, String cargo_cont, int estado_cont, Date fecha_inicio_con,
			Date fecha_fin_con) {
		super();
		this.cod_persona = cod_persona;
		this.cod_cont = cod_cont;
		this.cargo_cont = cargo_cont;
		this.estado_cont = estado_cont;
		this.fecha_inicio_con = fecha_inicio_con;
		this.fecha_fin_con = fecha_fin_con;
	}


	public Contadores(int cod_persona) {
		super();
		this.cod_persona = cod_persona;
	}


	public Contadores(int cod_cont, String cargo_cont, int estado_cont, Date fecha_inicio_con, Date fecha_fin_con) {
		super();
		this.cod_cont = cod_cont;
		this.cargo_cont = cargo_cont;
		this.estado_cont = estado_cont;
		this.fecha_inicio_con = fecha_inicio_con;
		this.fecha_fin_con = fecha_fin_con;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
	}


	public int getCod_cont() {
		return cod_cont;
	}


	public void setCod_cont(int cod_cont) {
		this.cod_cont = cod_cont;
	}


	public String getCargo_cont() {
		return cargo_cont;
	}


	public void setCargo_cont(String cargo_cont) {
		this.cargo_cont = cargo_cont;
	}


	public int getEstado_cont() {
		return estado_cont;
	}


	public void setEstado_cont(int estado_cont) {
		this.estado_cont = estado_cont;
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
	