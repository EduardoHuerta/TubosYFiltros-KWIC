package filters;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Output extends Filter{

    public Output(Pipe inputAlUltimoFiltro){ super(inputAlUltimoFiltro); }


    public void run() {
        try {
            System.out.println("Filtro de salida");
            String orderedLines = input.read();
            String archivoSalida;
            String[] lines = orderedLines.split("\\n");
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Filtro de salida");
            jFileChooser.setCurrentDirectory(new File("src"));
            int res = jFileChooser.showSaveDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                archivoSalida = jFileChooser.getSelectedFile().getPath();
            } else {
                archivoSalida = "src/output.txt";
            }
            FileWriter fw = new FileWriter(archivoSalida);
             PrintWriter pw = new PrintWriter(fw);

            for(String line : lines) {
                pw.println(line);
            }
            pw.close();

            System.out.println("Se a creado satisfactoriamente el archivo txt de salida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
