package planillas;

public class TempoSobresPlanilla {
	
	private int cod_sobre;
	private int cod_planilla;
	private int cod_persona;
	private int diezmos;
	private int ofrendas;
	private int necesitados;
	private int mercados;
	private int construccion;
	private int misiones;
	private int otros;
	private int especial;
	
	
	public TempoSobresPlanilla() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TempoSobresPlanilla(int cod_sobre, int cod_planilla, int cod_persona, int diezmos, int ofrendas,
			int necesitados, int mercados, int construccion, int misiones, int otros, int especial) {
		super();
		this.cod_sobre = cod_sobre;
		this.cod_planilla = cod_planilla;
		this.cod_persona = cod_persona;
		this.diezmos = diezmos;
		this.ofrendas = ofrendas;
		this.necesitados = necesitados;
		this.mercados = mercados;
		this.construccion = construccion;
		this.misiones = misiones;
		this.otros = otros;
		this.especial = especial;
	}


	public TempoSobresPlanilla(int cod_sobre) {
		super();
		this.cod_sobre = cod_sobre;
	}


	public TempoSobresPlanilla(int cod_planilla, int cod_persona, int diezmos, int ofrendas, int necesitados,
			int mercados, int construccion, int misiones, int otros, int especial) {
		super();
		this.cod_planilla = cod_planilla;
		this.cod_persona = cod_persona;
		this.diezmos = diezmos;
		this.ofrendas = ofrendas;
		this.necesitados = necesitados;
		this.mercados = mercados;
		this.construccion = construccion;
		this.misiones = misiones;
		this.otros = otros;
		this.especial = especial;
	}


	public int getCod_sobre() {
		return cod_sobre;
	}


	public void setCod_sobre(int cod_sobre) {
		this.cod_sobre = cod_sobre;
	}


	public int getCod_planilla() {
		return cod_planilla;
	}


	public void setCod_planilla(int cod_planilla) {
		this.cod_planilla = cod_planilla;
	}


	public int getCod_persona() {
		return cod_persona;
	}


	public void setCod_persona(int cod_persona) {
		this.cod_persona = cod_persona;
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


	
	
	

}
