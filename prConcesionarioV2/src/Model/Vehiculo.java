package Model;

public class Vehiculo {

    int idVehiculo;
    String marca;
    String modelo;
    String estado;
    String tipoOferta;
    int kilometros;
    String cilindrada;
    double precio;
    String tipoCombustible;
    String tipoCambio;
    int anyoFabricacion;
    double precioSinIva;
    String matricula;
    int unidades;
    private byte[] foto;

/*getter*/
public int getIdVehiculo(){
    return idVehiculo;
}
public String getMarca(){
    return marca;
}
public String getModelo(){
    return modelo;
}
public String getEstado(){
    return estado;
}
public String getTipoOferta(){
    return tipoOferta;
}
public int getKilometros(){
    return kilometros;
}
public String getCilindrada(){
    return cilindrada;
}
public double getPrecio(){
    return precio;
}
public String getTipoCombustible(){
    return tipoCombustible;
}
public String getTipoCambio(){
    return tipoCambio;
}
public int getAnyoFabricacion(){
    return anyoFabricacion;
}
public double getPrecioSinIva(){
    return precioSinIva;
}
public String getMatricula() {
	return matricula;
}
public byte[] getFoto() {
    return foto;
}


/*setter*/
public void setIdVehiculo(int idVehiculo){
    this.idVehiculo = idVehiculo;
}
public void setMarca(String marca){
    this.marca = marca;
}
public void setModelo(String modelo){
    this.modelo = modelo;
}
public void setEstado(String estado){
    this.estado = estado;
}
public void setTipoOferta(String tipoOferta){
    this.tipoOferta = tipoOferta;
}
public void setKilometros(int kilometros){
    this.kilometros = kilometros;
}
public void setCilindrada(String cilindrada){
    this.cilindrada = cilindrada;
}
public void setPrecio(double precio){
    this.precio = precio;
}
public void setTipoCombustible(String tipoCombustible){
    this.tipoCombustible = tipoCombustible;
}
public void setTipoCambio(String tipoCambio){
    this.tipoCambio = tipoCambio;
}
public void setAnyoFabricacion(int anyoFabricacion){
    this.anyoFabricacion = anyoFabricacion;
}
public void setPrecioSinIva(double precioSinIva){
    this.precioSinIva = precioSinIva;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public void setFoto(byte[] foto) {
    this.foto = foto;
}
public int getUnidades() {
	return unidades;
}
public void setUnidades(int unidades) {
	this.unidades = unidades;
}

}
