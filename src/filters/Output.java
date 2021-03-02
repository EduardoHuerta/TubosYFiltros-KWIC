package filters;

import javax.swing.*;
import java.io.*;

public class Output extends Filter{

    public Output(Pipe inputAlUltimoFiltro){ super(inputAlUltimoFiltro,null); }


    public void transform() {
        try {
            System.out.println("Filtro de salida");
            String[] orderedLines = input.read().trim().split("\n");
            String archivoSalida;
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Filtro de salida");
            jFileChooser.setCurrentDirectory(new File("src"));
            int res = jFileChooser.showSaveDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                archivoSalida = jFileChooser.getSelectedFile().getPath();
            } else {
                archivoSalida = "src/output.txt";
            }
            PrintWriter pw = new PrintWriter(archivoSalida);

            for(String line : orderedLines) {
                pw.println(line);
            }
            pw.flush();
            System.out.println("Se a creado satisfactoriamente el archivo txt de salida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
