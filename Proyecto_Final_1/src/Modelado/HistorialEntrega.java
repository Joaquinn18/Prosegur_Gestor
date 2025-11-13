package Modelado;

public class HistorialEntrega {
    private final String fecha;
    private final String cliente;
    private final String direccion;
    private final String banco;
    private final String mensajeroNombre;
    private final String mensajeroDni;
    private final boolean conforme;

    public HistorialEntrega(String fecha,
                             String cliente,
                             String direccion,
                             String banco,
                             String mensajeroNombre,
                             String mensajeroDni,
                             boolean conforme) {
        this.fecha = sanitize(fecha);
        this.cliente = sanitize(cliente);
        this.direccion = sanitize(direccion);
        this.banco = sanitize(banco);
        this.mensajeroNombre = sanitize(mensajeroNombre);
        this.mensajeroDni = sanitize(mensajeroDni);
        this.conforme = conforme;
    }

    private String sanitize(String value) {
        return value == null ? "" : value.trim();
    }

    public String getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getBanco() {
        return banco;
    }

    public String getMensajeroNombre() {
        return mensajeroNombre;
    }

    public String getMensajeroDni() {
        return mensajeroDni;
    }

    public boolean isConforme() {
        return conforme;
    }

    public String getMensajeroDisplay() {
        if (mensajeroNombre == null || mensajeroNombre.trim().isEmpty()) {
            return mensajeroDni == null ? "" : mensajeroDni;
        }
        if (mensajeroDni == null || mensajeroDni.trim().isEmpty()) {
            return mensajeroNombre;
        }
        return mensajeroNombre + " (" + mensajeroDni + ")";
    }
}