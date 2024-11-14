package modelos;

public class Pago {

	private int importe_total;
	private int costo_por_envio;
	private int nroTarjeta;
	private int codeSec;
	private String nombreUsuario;
	private int dniUsuario;
	
	public Pago(int importe_total, int costo_por_envio, int nroTarjeta, int codeSec, String nombreUsuario,
			int dniUsuario) {
		super();
		this.importe_total = importe_total;
		this.costo_por_envio = costo_por_envio;
		this.nroTarjeta = nroTarjeta;
		this.codeSec = codeSec;
		this.nombreUsuario = nombreUsuario;
		this.dniUsuario = dniUsuario;
	}
	public int getImporte_total() {
		return importe_total;
	}
	public void setImporte_total(int importe_total) {
		this.importe_total = importe_total;
	}
	public int getCosto_por_envio() {
		return costo_por_envio;
	}
	public void setCosto_por_envio(int costo_por_envio) {
		this.costo_por_envio = costo_por_envio;
	}
	public int getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(int nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public int getCodeSec() {
		return codeSec;
	}
	public void setCodeSec(int codeSec) {
		this.codeSec = codeSec;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(int dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	
	
}
