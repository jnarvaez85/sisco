package planillas;

public class TempoSobresPlanilla {
	
	private int cod_sobre;
	private int cod_planilla;
	private int cod_persona;
	private double diezmos;
	private double ofrendas;
	private double necesitados;
	private double mercados;
	private double construccion;
	private double misiones;
	private double otros;
	private double especial;
	
	
	public TempoSobresPlanilla() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TempoSobresPlanilla(int cod_sobre, int cod_planilla, int cod_persona, double diezmos, double ofrendas,
			double necesitados, double mercados, double construccion, double misiones, double otros, double especial) {
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


	public TempoSobresPlanilla(int cod_planilla, int cod_persona, double diezmos, double ofrendas, double necesitados,
			double mercados, double construccion, double misiones, double otros, double especial) {
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


	public double getDiezmos() {
		return diezmos;
	}


	public void setDiezmos(double diezmos) {
		this.diezmos = diezmos;
	}


	public double getOfrendas() {
		return ofrendas;
	}


	public void setOfrendas(double ofrendas) {
		this.ofrendas = ofrendas;
	}


	public double getNecesitados() {
		return necesitados;
	}


	public void setNecesitados(double necesitados) {
		this.necesitados = necesitados;
	}


	public double getMercados() {
		return mercados;
	}


	public void setMercados(double mercados) {
		this.mercados = mercados;
	}


	public double getConstruccion() {
		return construccion;
	}


	public void setConstruccion(double construccion) {
		this.construccion = construccion;
	}


	public double getMisiones() {
		return misiones;
	}


	public void setMisiones(double misiones) {
		this.misiones = misiones;
	}


	public double getOtros() {
		return otros;
	}


	public void setOtros(double otros) {
		this.otros = otros;
	}


	public double getEspecial() {
		return especial;
	}


	public void setEspecial(double especial) {
		this.especial = especial;
	}
	
	
	

}
