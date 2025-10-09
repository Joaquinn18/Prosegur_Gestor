package Modelado;

public class DetalleEntrega {
	  private String cliente;
	    private String banco;
	    private String direccion;
	    private boolean conforme;

	    public DetalleEntrega(String cliente, String banco, String direccion, boolean conforme) {
	        this.cliente = cliente;
	        this.banco = banco;
	        this.direccion = direccion;
	        this.conforme = conforme;
	    }

	    public String getCliente() { return cliente; }
	    public void setCliente(String cliente) { this.cliente = cliente; }

	    public String getBanco() { return banco; }
	    public void setBanco(String banco) { this.banco = banco; }

	    public String getDireccion() { return direccion; }
	    public void setDireccion(String direccion) { this.direccion = direccion; }

	    public boolean isConforme() { return conforme; }
	    public void setConforme(boolean conforme) { this.conforme = conforme; }
}
