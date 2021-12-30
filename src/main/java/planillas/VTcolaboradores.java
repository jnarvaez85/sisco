package planillas;

public class VTcolaboradores {
	
	private int cod_colabora;
	private int cod_persona;
	private String tipo_identificacion;
	private String identificacion;
	private String nombre_colaborador;
	private String dir_colaborador;
	private String tel_colaborador;
	private int cod_estado;
	private String estado;
	
	
	public VTcolaboradores() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VTcolaboradores(int cod_colabora, int cod_persona, String tipo_identificacion, String identificacion,
			String nombre_colaborador, String dir_colaborador, String tel_colaborador, int cod_estado, String estado) {
		super();
		this.cod_colabora = cod_colabora;
		this.cod_persona = cod_persona;
		this.tipo_identificacion = tipo_identificacion;
		this.identificacion = identificacion;
		this.nombre_colaborador = nombre_colaborador;
		this.dir_colaborador = dir_colaborador;
		this.tel_colaborador = tel_colaborador;
		this.cod_estado = cod_estado;
		this.estado = estado;
	}


	public VTcolaboradores(int cod_colabora) {
		super();
		this.cod_colabora = cod_colabora;
	}


	public VTcolaboradores(int cod_persona, String tipo_identificacion, String identificacion,
			String nombre_colaborador, String dir_colaborador, String tel_colaborador, int cod_estado, String estado) {
		super();
		this.cod_persona = cod_persona;
		this.tipo_identificacion = tipo_identificacion;
		this.identificacion = identificacion;
		this.nombre_colaborador = nombre_colaborador;
		this.dir_colaborador = dir_colaborador;
		this.tel_colaborador = tel_colaborador;
		this.cod_estado = cod_estado;
		this.estado = estado;
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


	public String getTipo_identificacion() {
		return tipo_identificacion;
	}


	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getNombre_colaborador() {
		return nombre_colaborador;
	}


	public void setNombre_colaborador(String nombre_colaborador) {
		this.nombre_colaborador = nombre_colaborador;
	}


	public String getDir_colaborador() {
		return dir_colaborador;
	}


	public void setDir_colaborador(String dir_colaborador) {
		this.dir_colaborador = dir_colaborador;
	}


	public String getTel_colaborador() {
		return tel_colaborador;
	}


	public void setTel_colaborador(String tel_colaborador) {
		this.tel_colaborador = tel_colaborador;
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
	
	
	
}
