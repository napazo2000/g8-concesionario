package Model;

public class Operacion {
	
	int IDoperacion;
	int Idvendedor;
	int IDvehiculo;
	int IDcliente;
	String Date;
	int Numdias;
	double Importe;
	String Financiacion;
	int Meses;
	String Formapago;
	String Tipooferta;
	
	//setter
	
	public void setIDoperacion(int iDoperacion) {
		IDoperacion = iDoperacion;
	}
	
	public void setIdvendedor(int idvendedor) {
		Idvendedor = idvendedor;
	}
	
	public void setIDvehiculo(int iDvehiculo) {
		IDvehiculo = iDvehiculo;
	}
	
	public void setIDcliente(int iDcliente) {
		IDcliente = iDcliente;
	}
	
	public void setDate(String date) {
		Date = date;
	}
	
	public void setNumdias(int numdias) {
		Numdias = numdias;
	}
	
	public void setImporte(double importe) {
		Importe = importe;
	}
	
	public void setFinanciacion(String financiacion) {
		Financiacion = financiacion;
	}
	
	public void setMeses(int meses) {
		Meses = meses;
	}
	
	public void setFormapago(String formapago) {
		Formapago = formapago;
	}
	
	public void setTipooferta(String tipooferta) {
		Tipooferta = tipooferta;
	
	}
	
	
	//getter
	
	public String getTipooferta() {
		return Tipooferta;
	}
	
	public String getFormapago() {
		return Formapago;
	}
	
	public int getMeses() {
		return Meses;
	}
	
	public String getFinanciacion() {
		return Financiacion;
	}
	
	public double getImporte() {
		return Importe;
	}
	
	public int getNumdias() {
		return Numdias;
	}
	
	public String getDate() {
		return Date;
	}
	
	public int getIDvehiculo() {
		return IDvehiculo;
	}
	
	public int getIDcliente() {
		return IDcliente;
	}
	
	public int getIdvendedor() {
		return Idvendedor;
	}
	
	public int getIDoperacion() {
		return IDoperacion;
	}

}