package filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularShift extends Filter {

    public CircularShift(Pipe in, Pipe out) { super(in, out); }

    public void run() {
        try {
            System.out.println("Filtro Circular Shift");
            String[] lines = input.read().trim().split("\\n");
            ArrayList<String> palabrasShifteadas = new ArrayList<String>();
            for (String inputSentence : lines) {
                ArrayList<String> words = splitSentencesToWords(inputSentence);
                for (int i = 0; i < words.size(); i++) {
                    String shiftedSentence = formSentenceFromWords(words, i);
                    palabrasShifteadas.add(shiftedSentence);
                }
            }
            for (String lineasPipes : palabrasShifteadas) {
                output.write(lineasPipes + "\n");
            }
            output.closeWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // El siguiente método forma una sentencia a partir de una lista de palabras
    private static String formSentenceFromWords(ArrayList<String> words, int offset) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            int idx = (i + offset) % words.size();
            String word = words.get(idx);
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    private ArrayList<String> splitSentencesToWords (String sentencia) {
        String[] palabras = sentencia.split("\\s+");
        return new ArrayList<>(Arrays.asList(palabras));
    }
}

