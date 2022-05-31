package planillas;

public class TempoDineroPlanilla {
	
	private int cod_planilla; 
	private int b_cien; 
	private int b_cincuenta; 
	private int b_veinte; 
	private int b_diez; 
	private int b_cinco; 
	private int b_dos; 
	private int b_mil; 
	private int m_mil; 
	private int m_quiniento; 
	private int m_dos; 
	private int m_cien; 
	private int m_cincuenta;
	private int estado;
	
	
	public TempoDineroPlanilla() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TempoDineroPlanilla(int cod_planilla, int b_cien, int b_cincuenta, int b_veinte, int b_diez, int b_cinco,
			int b_dos, int b_mil, int m_mil, int m_quiniento, int m_dos, int m_cien, int m_cincuenta, int estado) {
		super();
		this.cod_planilla = cod_planilla;
		this.b_cien = b_cien;
		this.b_cincuenta = b_cincuenta;
		this.b_veinte = b_veinte;
		this.b_diez = b_diez;
		this.b_cinco = b_cinco;
		this.b_dos = b_dos;
		this.b_mil = b_mil;
		this.m_mil = m_mil;
		this.m_quiniento = m_quiniento;
		this.m_dos = m_dos;
		this.m_cien = m_cien;
		this.m_cincuenta = m_cincuenta;
		this.estado = estado;
	}


	public TempoDineroPlanilla(int cod_planilla) {
		super();
		this.cod_planilla = cod_planilla;
	}


	public TempoDineroPlanilla(int b_cien, int b_cincuenta, int b_veinte, int b_diez, int b_cinco, int b_dos, int b_mil,
			int m_mil, int m_quiniento, int m_dos, int m_cien, int m_cincuenta, int estado) {
		super();
		this.b_cien = b_cien;
		this.b_cincuenta = b_cincuenta;
		this.b_veinte = b_veinte;
		this.b_diez = b_diez;
		this.b_cinco = b_cinco;
		this.b_dos = b_dos;
		this.b_mil = b_mil;
		this.m_mil = m_mil;
		this.m_quiniento = m_quiniento;
		this.m_dos = m_dos;
		this.m_cien = m_cien;
		this.m_cincuenta = m_cincuenta;
		this.estado = estado;
	}


	public int getCod_planilla() {
		return cod_planilla;
	}


	public void setCod_planilla(int cod_planilla) {
		this.cod_planilla = cod_planilla;
	}


	public int getB_cien() {
		return b_cien;
	}


	public void setB_cien(int b_cien) {
		this.b_cien = b_cien;
	}


	public int getB_cincuenta() {
		return b_cincuenta;
	}


	public void setB_cincuenta(int b_cincuenta) {
		this.b_cincuenta = b_cincuenta;
	}


	public int getB_veinte() {
		return b_veinte;
	}


	public void setB_veinte(int b_veinte) {
		this.b_veinte = b_veinte;
	}


	public int getB_diez() {
		return b_diez;
	}


	public void setB_diez(int b_diez) {
		this.b_diez = b_diez;
	}


	public int getB_cinco() {
		return b_cinco;
	}


	public void setB_cinco(int b_cinco) {
		this.b_cinco = b_cinco;
	}


	public int getB_dos() {
		return b_dos;
	}


	public void setB_dos(int b_dos) {
		this.b_dos = b_dos;
	}


	public int getB_mil() {
		return b_mil;
	}


	public void setB_mil(int b_mil) {
		this.b_mil = b_mil;
	}


	public int getM_mil() {
		return m_mil;
	}


	public void setM_mil(int m_mil) {
		this.m_mil = m_mil;
	}


	public int getM_quiniento() {
		return m_quiniento;
	}


	public void setM_quiniento(int m_quiniento) {
		this.m_quiniento = m_quiniento;
	}


	public int getM_dos() {
		return m_dos;
	}


	public void setM_dos(int m_dos) {
		this.m_dos = m_dos;
	}


	public int getM_cien() {
		return m_cien;
	}


	public void setM_cien(int m_cien) {
		this.m_cien = m_cien;
	}


	public int getM_cincuenta() {
		return m_cincuenta;
	}


	public void setM_cincuenta(int m_cincuenta) {
		this.m_cincuenta = m_cincuenta;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	
	
	
	

}
