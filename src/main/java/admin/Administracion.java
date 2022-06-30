package admin;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Administracion {
	
	
	
	
	// CAMPOS NUMERICOS VACIOS
	public int validarCampoNumero(String num) {
		
		if (num==null || num.equals("")) {
			return 0;
	}else {
		return Integer.parseInt(num);
		}
	}
	
	
	
	
	// FORMATO FECHA	
	public String formatoFecha(Date date,String formato) {
		if (date == null)
			return "";
		return new SimpleDateFormat(formato).format(date);
	}
	
	
	
	public String formatoFechaDMY(Date date) {
		if (date == null)
			return "";
		return formatoFecha(date, "dd/MM/yyyy");
	}
	
	
	
	
	
	// FORMATO  MILES	
	public String formatoMiles(String valor){
		if (valor.length()<=3)
			return valor;
		double val = Double.parseDouble(valor);
		DecimalFormat df = new DecimalFormat("#,###.##");
		return df.format(val);
	}

	public String formatoMiles(Object valor){
		try {
			return formatoMiles(String.valueOf(valor));
		}catch(Exception e){
			return "";
		}
	}
	
	
	
	// VALIDA INGRESO DE DINERO	
	public boolean validaIngresoDinero(int b_cien, int b_cincuenta, int b_veinte, int b_diez, int b_cinco, int b_dos, int b_mil, int m_mil, int m_quiniento, int m_dos, int m_cien, int m_cincuenta) {
	
		if (b_cien == 0 && b_cincuenta==0 && b_veinte==0 && b_diez==0 && b_cinco==0 && b_dos==0 && b_mil==0 && m_mil==0 && m_quiniento==0 && m_dos==0 && m_cien==0 && m_cincuenta==0) {
			return false;
		}else {
			return true;
		}		
	}
	
	
	// VALIDA INGRESO DE SOBRES
	public boolean validaIngresoSobres(int diezmos, int ofrendas, int necesitados, int mercados, int construccion, int misiones) {
	
		if (diezmos == 0 && ofrendas==0 && necesitados==0 && mercados==0 && construccion==0 && misiones==0) {
			return false;
		}else {
			return true;
		}		
	}
	

}
