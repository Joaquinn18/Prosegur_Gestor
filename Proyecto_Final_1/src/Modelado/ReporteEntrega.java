package Modelado;

public class ReporteEntrega {
	 private String dni;
	    private String nombres;
	    private int inicial;     
	    private int entregado;   
	    private int restante;    
	    private double porcentaje; 

	    public ReporteEntrega(String dni, String nombres, int inicial, int entregado, int restante, double porcentaje) {
	        this.dni = dni;
	        this.nombres = nombres;
	        this.inicial = inicial;
	        this.entregado = entregado;
	        this.restante = restante;
	        this.porcentaje = porcentaje;
	    }

	 
	    public String getDni() { return dni; }
	    public String getNombres() { return nombres; }
	    public int getInicial() { return inicial; }
	    public int getEntregado() { return entregado; }
	    public int getRestante() { return restante; }
	    public double getPorcentaje() { return porcentaje; }
}
