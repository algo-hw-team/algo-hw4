package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainApp {
	private final static String basePath = "c:/hw4/";
    private final static String inputPath = basePath + "input.txt";
    private final static String outputPath = basePath + "2013147550.txt";

    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        int [][]boardValues;
        
        try {
            //모든 인풋 텍스트를 라인단위로 리스트에 저장한다.
            BufferedReader br = new BufferedReader(new FileReader(inputPath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
            String sCurrentLine;
            ArrayList<String> inputlist = new ArrayList<>();
            while ((sCurrentLine = br.readLine()) != null) {
                inputlist.add(sCurrentLine);
            }

            br.close();

            // algorithm
            int index = 0;
            int testCases = Integer.parseInt(inputlist.get(index++));
            for (int i = 0; i < testCases; i++) {
            	int columns = Integer.parseInt(inputlist.get(index++));
            	boardValues = new int[columns][4];
            	for (int j = 0; j < 4; j++) {
            		String[] num = inputlist.get(index++).split(" ");
            		for (int k = 0; k < columns; k++) {
            			boardValues[k][j] = Math.abs((Integer.parseInt(num[k])));
            		}
            	}
                MaxPebbleFinder finder = new MaxPebbleFinder(columns, boardValues);
                builder.append(finder.getMaxPlacementSum());
                builder.append(System.getProperty("line.separator"));
            }
            String output = builder
                    .toString()
                    .trim();

            bw.write(output);
            bw.flush();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}