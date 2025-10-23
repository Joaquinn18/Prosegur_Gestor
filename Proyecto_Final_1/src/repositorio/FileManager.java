package repositorio;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import Modelado.Motorizado;
import Modelado.Entrega;
public class FileManager {


    public static void exportarMotorizadosCSV(List<Motorizado> lista, Path archivo) throws IOException {
     
        if (archivo.getParent() != null) Files.createDirectories(archivo.getParent());
        try (BufferedWriter w = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
            
            w.write("id,dni,nombres,apellidos,celular,placa,marca,modelo,tarjetasAsignadas,estado,fechaIngreso,contrato,idSede");
            w.newLine();
            for (Motorizado m : lista) {
                String[] cols = new String[] {
                    String.valueOf(m.getId()),
                    escapeCsv(m.getDni()),
                    escapeCsv(m.getNombres()),
                    escapeCsv(m.getApellidos()),
                    escapeCsv(m.getCelular()),
                    escapeCsv(m.getPlaca()),
                    escapeCsv(m.getMarca()),
                    escapeCsv(m.getModelo()),
                    String.valueOf(m.getTarjetasAsignadas()),
                    escapeCsv(m.getEstado()),
                    escapeCsv(m.getFechaIngreso()),
                    escapeCsv(m.getContrato()),
                    String.valueOf(m.getIdSede())
                };
                w.write(String.join(",", cols));
                w.newLine();
            }
        }
    }

    public static List<Motorizado> importarMotorizadosCSV(Path archivo) throws IOException {
        List<Motorizado> lista = new ArrayList<>();
        try (BufferedReader r = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String header = r.readLine(); 
            String line;
            while ((line = r.readLine()) != null) {
                
                String[] cols = line.split(",", -1);
              
                if (cols.length < 13) continue;
                try {
                    Motorizado m = new Motorizado(
                        Integer.parseInt(cols[0].trim()),
                        cols[1].trim(),
                        cols[2].trim(),
                        cols[3].trim(),
                        cols[4].trim(),
                        cols[5].trim(),
                        cols[6].trim(),
                        cols[7].trim(),
                        "", 
                        "", 
                        false, 
                        cols[9].trim(), 
                        cols[10].trim(), 
                        cols[11].trim(), 
                        Integer.parseInt(cols[12].trim()) 
                    );
                    lista.add(m);
                } catch (Exception ex) {
                    
                    System.err.println("Linea CSV inválida (motorizado) -> omitida: " + line);
                }
            }
        }
        return lista;
    }

    
    public static void exportarEntregasCSV(List<Entrega> lista, Path archivo) throws IOException {
        if (archivo.getParent() != null) Files.createDirectories(archivo.getParent());
        try (BufferedWriter w = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
            w.write("id,dni,cantidad,requestedCantidad,fecha");
            w.newLine();
            for (Entrega e : lista) {
                String[] cols = new String[] {
                    String.valueOf(e.getId()),
                    escapeCsv(e.getDniMotorizado()),
                    String.valueOf(e.getCantidad()),
                    String.valueOf(e.getRequestedCantidad()),
                    escapeCsv(e.getFecha())
                };
                w.write(String.join(",", cols));
                w.newLine();
            }
        }
    }

    public static List<Entrega> importarEntregasCSV(Path archivo) throws IOException {
        List<Entrega> lista = new ArrayList<>();
        try (BufferedReader r = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String header = r.readLine();
            String line;
            while ((line = r.readLine()) != null) {
                String[] cols = line.split(",", -1);
                if (cols.length < 5) continue;
                try {
                    Entrega e = new Entrega(
                        Integer.parseInt(cols[0].trim()),
                        cols[1].trim(),
                        Integer.parseInt(cols[2].trim()), 
                        Integer.parseInt(cols[3].trim()), 
                        cols[4].trim(),
                        null
                    );
                    lista.add(e);
                } catch (Exception ex) {
                    System.err.println("Linea CSV inválida (entrega) -> omitida: " + line);
                }
            }
        }
        return lista;
    }

    
    public static void backupFile(Path src, Path dest) throws IOException {
        if (src == null || dest == null) throw new IllegalArgumentException("Rutas inválidas para backup.");
        if (src.getParent() != null) Files.createDirectories(dest.getParent());
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }

   
    private static String escapeCsv(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
           
            String q = s.replace("\"", "\"\"");
            return "\"" + q + "\"";
        }
        return s;
    }
}
