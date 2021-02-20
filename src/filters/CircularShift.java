package filters;

import java.io.IOException;
import java.util.ArrayList;

public class CircularShift extends Filter{

    public CircularShift(Pipe in, Pipe out){
        super(in,out);
    }

    //execute a single shift
    private String[] shift(String[] line) {
        String[] shiftLine = line.clone();

        String shiftWord = shiftLine[0];
        for(int i = 0; i < shiftLine.length - 1; ++i)
            shiftLine[i] = shiftLine[i + 1];

        shiftLine[shiftLine.length - 1] = shiftWord;
        return shiftLine;
    }

    //execute 'times' consecutive single shift over the same line
    private String[] shiftTimes(String[] line, int times) {
        String[] shiftedTimes = line.clone();
        while(times > 0) {
            shiftedTimes = shift(shiftedTimes);
            --times;
        }
        return shiftedTimes;
    }

    private ArrayList<String[]> shiftLine(String[] line){
        ArrayList<String[]> shiftedLine = new ArrayList<String[]>();
        for(int i = 0; i < line.length; ++i) {
            String[] shifted = shiftTimes(line, i);
            shiftedLine.add(shifted);
        }
        return shiftedLine;
    }

    private ArrayList<String[]> shiftLines(String[] lines){
        ArrayList<String[]> originLinesByWords = Utils.SplitLinesByWords(lines);
        ArrayList<String[]> shiftedLines = new ArrayList<String[]>();

        for(String[] line : originLinesByWords) {   //
            ArrayList<String[]> shiftedLine = shiftLine(line);
            shiftedLines.addAll(shiftedLine);
        }
        return shiftedLines;
    }

    public void run() {
        try {
            String lines[] = input.read().trim().split("\\n");
            Utils.RemoveChangeOfLineChars(lines);

            ArrayList<String[]> shiftedLines = shiftLines(lines);

            output.write(Utils.rebuildString(shiftedLines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
