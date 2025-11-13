package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import Controlador.ControladorMotorizado;
import Modelado.ReporteEntrega;

public class ReporteEntregasFrame extends JFrame {
	   private ControladorMotorizado controlador;
	    private DefaultTableModel modeloTabla;
	    private JTable tabla;

	    public ReporteEntregasFrame(ControladorMotorizado controlador) {
	        this.controlador = controlador;

	        setTitle("Reporte de Entregas por Motorizado");
	        setSize(800, 400);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // columnas: DNI, Nombres, Inicial, Entregado, Restante, %Cumplimiento
	        String[] columnas = {"DNI", "Nombres", "Inicial", "Entregado", "Restante", "% Cumplimiento"};
	        modeloTabla = new DefaultTableModel(columnas, 0) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // solo lectura
	            }
	        };
	        tabla = new JTable(modeloTabla);
	        JScrollPane scroll = new JScrollPane(tabla);

	        // panel botones
	        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JButton btnRefrescar = new JButton("Refrescar");
	        JButton btnCerrar = new JButton("Cerrar");
	        panelTop.add(btnRefrescar);
	        panelTop.add(btnCerrar);

	        add(panelTop, BorderLayout.NORTH);
	        add(scroll, BorderLayout.CENTER);

	        // listeners
	        btnRefrescar.addActionListener(e -> cargarReporte());
	        btnCerrar.addActionListener(e -> dispose());

	        // carga inicial
	        cargarReporte();
	    }

	    private void cargarReporte() {
	        modeloTabla.setRowCount(0);
	        if (controlador == null) {
	            controlador = new ControladorMotorizado();
	        }
	        List<ReporteEntrega> lista = controlador.generarReporteEntregas();
	        for (ReporteEntrega r : lista) {
	            modeloTabla.addRow(new Object[]{
	                    r.getDni(),
	                    r.getNombres(),
	                    r.getInicial(),
	                    r.getEntregado(),
	                    r.getRestante(),
	                    String.format("%.2f%%", r.getPorcentaje())
	            });
	        }
	    }
}
